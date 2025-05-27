import kotlin.math.roundToInt

fun main() {
    tryTransferMoney("VK Pay", 0, 75_600)
}

fun tryTransferMoney(typeCard: String, preTransfer: Int = 0, transfer: Int): Boolean {

    var dayLimit = 150_000
    var monthLimit = 600_000

    if (typeCard == "VK Pay") {
        dayLimit = 15_000
        monthLimit = 40_000
    }

    val monthTransfer = transfer + preTransfer;

    if (transfer > dayLimit || monthTransfer > monthLimit) {
        println("Операция отклонена. Превышен лимит переводов")
        return false;
    }

    val commission = when (typeCard) {
        "Mastercard", "Maestro" -> masterCardMaestroCalculateCommission(transfer, preTransfer)
        "Visa", "Мир" -> visaMirCalculateCommission(transfer)
        else -> 0
    }

    println("Операция одобрена.\nКомиссия составит: $commission руб.")
    return true
}

fun masterCardMaestroCalculateCommission(transfer: Int, preTransfer: Int): Int {
    val masterCardLowLimitWithotComm = 300
    val masterCardHighLimitWithotComm = 75_000
    val commissionPercent = 0.006
    val commissionAdd = 20
    val commission =
        if (preTransfer + transfer >= masterCardLowLimitWithotComm &&
            preTransfer + transfer <= masterCardHighLimitWithotComm
        ) {
            0
        } else {
            when {
                preTransfer >= masterCardHighLimitWithotComm ->
                    (transfer * commissionPercent).roundToInt() + commissionAdd

                transfer < masterCardLowLimitWithotComm ->
                    (transfer * commissionPercent).roundToInt() + commissionAdd

                else ->
                    ((transfer + preTransfer - masterCardHighLimitWithotComm) * commissionPercent).roundToInt() + commissionAdd
            }
        }
    return commission
}

fun visaMirCalculateCommission(transfer: Int): Int {
    val commissionPercent = 0.0075
    val minCommission = 35
    return Math.max(minCommission, (transfer * commissionPercent).roundToInt());
}