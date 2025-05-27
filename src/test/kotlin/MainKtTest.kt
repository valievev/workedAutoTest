import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

 @Test
 fun tryTransferMoneyMasterCardTrue() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "Mastercard"
  val preTransfer = 0
  val transfer = 75_000

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(true, res)
 }
 @Test
 fun tryTransferMoneyMasterCardFalse() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "Mastercard"
  val preTransfer = 750_001
  val transfer = 750_000

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(false, res)
 }
 @Test
 fun tryTransferMoneyVkPayFalse() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "VK Pay"
  val preTransfer = 75_000
  val transfer = 75_000

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(false, res)
 }

 @Test
 fun tryTransferMoneyVisaTrue() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "Visa"
  val preTransfer = 0
  val transfer = 75_000

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(true, res)
 }
 @Test
 fun tryTransferMoneyMastercardTrueLowLimit() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "Mastercard"
  val preTransfer = 0
  val transfer = 70

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(true, res)
 }
 @Test
 fun tryTransferMoneyMastercardTrueHighLimit() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "Mastercard"
  val preTransfer = 75_000
  val transfer = 70_000

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(true, res)
 }
 @Test
 fun tryTransferMoneyMastercardTrueHighLimit2() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "Mastercard"
  val preTransfer = 70_000
  val transfer = 5_700

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(true, res)
 }
 @Test
 fun tryTransferMoneyNone() {
  //typeCard: String, preTransfer: Int = 0, transfer: Int
  val typeCard = "AAA"
  val preTransfer = 0
  val transfer = 75_000

  var res = tryTransferMoney(typeCard, preTransfer, transfer)
  assertEquals(true, res)
 }
}