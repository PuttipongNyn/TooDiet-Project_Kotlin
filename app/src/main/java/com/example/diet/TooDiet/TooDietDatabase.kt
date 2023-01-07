package com.example.diet.TooDiet

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.SeekBar
import com.example.diet.R

class TooDietDatabase(context: Context): SQLiteOpenHelper(context, databaseName, null, databaseVersion){

    companion object{
        const val databaseName = "TooDiet.db"
        const val databaseTable = "FoodList"
        const val databaseVersion = 1
        const val ID = "ID"
        const val Name = "Name"
        const val Amount = "Amount"
        const val Calories = "Calories"
        const val Type = "Type"

        const val databaseTable2 = "ExerciseList"
        const val ID2 = "ID"
        const val Name2 = "Name"
        const val Hour = "Hour"
        const val Calories2 = "Calories"

        const val databaseUser = "User"
        const val IDUser = "ID"
        const val Sex = "Sex"
        const val Height = "Height"
        const val Weight = "Weight"
        const val TDEE = "TDEE"
        const val BMR = "BMR"
        const val WeightTarget = "WeightTarget"
        const val Date = "Date"

        const val Summary = "Summary"
        const val SumFood = "SumFood"
        const val SumEx = "SumEx"

        var TempFood = 0
        var TempEx = 0


    }


    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = ("CREATE TABLE $databaseTable($ID INTEGER PRIMARY KEY, $Name TEXT, $Amount INTEGER, $Calories INTEGER, $Type STRING)")
        val createTable2 = ("CREATE TABLE $databaseTable2($ID2 INTEGER PRIMARY KEY, $Name2 TEXT, $Hour INTEGER, $Calories2 INTEGER)")
        val createTableUser = ("CREATE TABLE $databaseUser($IDUser INTEGER PRIMARY KEY AUTOINCREMENT, $Sex TEXT, Age INTEGER, $Height INTEGER, $Weight INTEGER, $TDEE INTEGER, $BMR FLOAT,$WeightTarget INTEGER, $Date INTEGER)")
        val cal = ("CREATE TABLE $Summary(ID INTEGER PRIMARY KEY AUTOINCREMENT, $SumFood INTEGER, $SumEx INTEGER)")
        db?.execSQL(createTable)
        db?.execSQL(createTable2)
        db?.execSQL(createTableUser)
        db?.execSQL(cal)
        db?.execSQL("INSERT INTO User(ID) VALUES(1)")
        db?.execSQL("INSERT INTO Summary(ID) VALUES(1)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('กระโดดเชือก',60,780)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('กวาดพื้น',60,225)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('การเต้น Zumba',60,500)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ขี่จักรยาน',60,350)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ขี่จักรยานด้วยความเร็ว 14.4กม.',60,415)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ขี่จักรยานด้วยความเร็ว 20.0กม.',60,660)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ซักผ้าด้วยมือ',60,240)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ตัดหญ้า',60,300)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ตีกอล์ฟ ลากถุงกอล์ฟ',60,300)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ตีกอล์ฟ แบกถุงกอล์ฟเอง',60,360)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ตีกอล์ฟ, นั่งรถ',60,240)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ทำงานบ้าน',60,150)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ทำสวน',60,300)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('นอนหลับ',60,75)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('นั่งดูทีวี',60,100)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('นั่งทำงานใช้สมอง',60,110)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('บาสเก็ตบอล',60,360)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ปูที่นอน',60,135)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('มวยไทย',60,800)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ยืน',60,140)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('รีดผ้า',60,150)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ลงนอน (ไม่หลับ)',60,85)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('วิ่งบนทางราบด้วยความเร็ว 12.8กม.',60,825)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('วิ่งบนทางราบด้วยความเร็ว 18.2กม.',60,1390)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('วิ่งเร็ว',60,900)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('วิ่งเหยาะๆ',60,600)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ว่ายน้ำด้วยความเร็ว 2.56กม.',60,700)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ว่ายน้ำด้วยความเร็ว 3.00กม.',60,850)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินขึ้นบันได',60,600)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินขึ้นเนิน',60,480)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินช้า',60,150)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินธรรมดา',60,300)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินลงบันได',60,425)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินลงเนิน',60,240)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินเร็ว',60,420)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินเล่น',60,210)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เย็บผ้า',60,115)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เลื่อยไม้',60,515)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นวอลเล่ย์บอล',60,300)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นสเก็ตปกติ',60,420)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นสเก็ตแข่งความเร็ว',60,700)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นฮูล่าฮูป',60,430)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นเทนนิสคู่',60,360)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นเทนนิสเดี่ยว',60,480)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นแบดมินตัน',60,350)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เล่นโบว์ลิ่ง',60,400)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('แอโรบิค',60,600)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('เดินขึ้นเขาหรือปีนเขา',60,800)")
        db?.execSQL("INSERT INTO ExerciseList(Name, Hour, Calories) VALUES('ออกกำลังกายแบบ HIT',60,700)")

        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กระเพาะปลา',150,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กระเพาะปลาตุ๋นน้ำแดง',225,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยไข่',40,1,'ผลไม้')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยฉาบ',29,1,'ขนม')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยตาก',30,1,'ขนม')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยทอด',50,1,'ขนม')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยน้ำว้า',36,1,'ผลไม้')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยบวชชี',152,1,'ขนม')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยเล็บมือนาง',30,1,'ผลไม้')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('กล้วยหอม',77,1,'ผลไม้')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยจั๊บ',240,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยจั๊บญวณ',235,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวแขก',380,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวคั่วไก่',435,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวต้มยำกุ้ง',320,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเนื้อเลียง',370,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเนื้อสับ',370,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวผัดกะเพราไก่',440,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวผัดไทยใส่ไข่',577,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวราดหน้าปลากระพง',435,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเรือน้ำตก',180,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเรือน้ำตกแห้ง',225,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเส้นปลาน้ำ',375,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเส้นปลาแห้ง',420,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเส้นเล็กต้มยำหมู',335,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเส้นเล็กหมูแห้ง',330,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเส้นหมี่น้ำลูกชิ้นเนื้อวัว',226,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเส้นหมี่ลูกชิ้นเนื้อ',258,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ก๋วยเตี๋ยวเส้นใหญ่ผัดซีอิ๊วใส่ไข่',520,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ขนมจีนใส่',80,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวกะเพราเนื้อ',622,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวกุ้งทอดกระเทียม',495,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวเกรียบกุ้ง',37,1,'ขนม')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดผักกระเฉดหมูกรอบ',600,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดมันกุ้งใส่ไข่',575,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดรวมมิตร (น้ำมันน้อย)',210,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดสับปะรด',335,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดไส้กรอก',520,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดหนำเลี้ยบ',370,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดหมูน้ำพริกเผา',665,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดหมูใส่ไข่',557,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดแหนม',610,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวผัดอเมริกัน',790,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวพะแนงเนื้อ',457,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวโพดต้ม',200,1,'ผลไม้')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวมันไก่',596,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวมันไก่ทอด',695,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวเม่าทอด',248,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวราดแกงเขียวหวานไก่',483,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวราดผัดผักบุ้ง ไข่ดาว',410,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวราดผัดผักใส่หมู',370,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวราดหน้าไก่',400,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวสตูไก่',465,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวสวย',68,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวสวย (ข้าวกล้อง)',80,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวหน้ากุ้งผัดพริกสด',540,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวหน้าเป็ด',495,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวหมกไก่',534,1,'อาหาร')")
        db?.execSQL("INSERT INTO FoodList(Name, Calories, Amount, Type) VALUES('ข้าวหมูแดง',541,1,'อาหาร')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXIST $databaseName")
        onCreate(db)
    }

    fun addData(flm: TooDietModel): Long{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("Name",flm.Name)
        cv.put("Amount",flm.Amount)
        cv.put("Calories",flm.Calories)
        cv.put("Type",flm.Type)
        val success = db.insert(databaseTable, null, cv)
        db.close()
        return success
    }

    fun getAllFood(): ArrayList<TooDietModel> {
        val arrayList:ArrayList<TooDietModel> = ArrayList()
        val selectQuery = "SELECT * FROM $databaseTable"
        val db = this.readableDatabase
        val cursor: Cursor?

        try{
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var ID: Int
        var Name: String
        var Amount: String
        var Calories: String
        var Type: String

        if(cursor.moveToNext()){
            do{
                ID = cursor.getInt(cursor.getColumnIndexOrThrow("ID"))
                Name = cursor.getString(cursor.getColumnIndexOrThrow("Name"))
                Amount = cursor.getString(cursor.getColumnIndexOrThrow("Amount"))
                Calories = cursor.getString(cursor.getColumnIndexOrThrow("Calories"))
                Type = cursor.getString(cursor.getColumnIndexOrThrow("Type"))

                val fl = TooDietModel(Id = ID, Name = Name, Amount = Amount, Calories = Calories, Type = Type)
                arrayList.add(fl)
            }while (cursor.moveToNext())
        }

        return arrayList
    }

    fun getTemp(): Cursor? {

        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $Summary" , null)

    }

    fun clearTempFood(): Int {
        var cv = ContentValues()
        cv.put(SumFood,0)
        val db = this.readableDatabase
        val success = db.update(Summary,cv,"ID=" +1,null)
        db.close()
        return success
    }

    fun clearTempEx(): Int {
        var cv = ContentValues()
        cv.put(SumEx,0)
        val db = this.readableDatabase
        val success = db.update(Summary,cv,"ID=" +1,null)
        db.close()
        return success
    }

    fun deleteFoodById(id:Int): Int{
        val db = this.writableDatabase

        val cv = ContentValues()
        cv.put(ID, id)

        val success = db.delete(databaseTable, "ID="+id, null)
        db.close()
        return success
    }

    fun deleteExerciseById(id:Int): Int{
        val db = this.writableDatabase

        val cv = ContentValues()
        cv.put(ID2, id)
        val success = db.delete(databaseTable2, "ID="+id, null)
        db.close()
        return success
    }

    fun addCalFoodById(id:Int,calories:String): Int{
        val db = this.writableDatabase

        val cv = ContentValues()

        var sumFood =  calories.toInt()

        TempFood += sumFood
        cv.put(SumFood, TempFood)

        Log.e("Caloreis", "$TempFood")
        Log.e("SUM", "$sumFood")
        val success = db.update(Summary, cv,"ID="+1, null)
        db.close()

        return success
    }

    fun addCalExById(id:Int,calories:String): Int{
        val db = this.writableDatabase

        val cv = ContentValues()

        var sumEx =  calories.toInt()

        TempEx += sumEx
        cv.put(SumEx, TempEx)

        Log.e("Caloreis", "$TempEx")
        Log.e("SUM", "$sumEx")
        val success = db.update(Summary, cv,"ID="+1, null)
        db.close()

        return success
    }

    fun addDataEx(flm: TooDietModel): Long{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("Name",flm.NameEx)
        cv.put("Hour",flm.Hour)
        cv.put("Calories",flm.CaloriesEx)
        val success = db.insert(databaseTable2, null, cv)
        db.close()
        return success
    }

    fun getAllExercise(): ArrayList<TooDietModel> {
        val arrayList:ArrayList<TooDietModel> = ArrayList()
        val selectQuery = "SELECT * FROM $databaseTable2"
        val db = this.readableDatabase
        val cursor: Cursor?

        try{
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var IDEx: Int
        var NameEx: String
        var Hour: String
        var CaloriesEx: String

        if(cursor.moveToNext()){
            do{
                IDEx = cursor.getInt(cursor.getColumnIndexOrThrow("ID"))
                NameEx = cursor.getString(cursor.getColumnIndexOrThrow("Name"))
                Hour = cursor.getString(cursor.getColumnIndexOrThrow("Hour"))
                CaloriesEx = cursor.getString(cursor.getColumnIndexOrThrow("Calories"))

                val fl = TooDietModel(IdEx = IDEx, NameEx = NameEx, Hour = Hour, CaloriesEx = CaloriesEx)
                arrayList.add(fl)
            }while (cursor.moveToNext())
        }

        return arrayList
    }


}
