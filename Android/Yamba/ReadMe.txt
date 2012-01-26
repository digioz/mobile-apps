The Yamba Android Application is based on the freely available Screencast by Marko Gargenta which can be viewed at:

http://marakana.com/techtv/android_bootcamp_screencast_series.html

More information about this App can be found here:

http://yamba.marakana.com/

Note: This application was coded in Eclipse IDE Version 1.3.2.20110301-1807 using Android Development Tools (ADT) Plug-in version 16.0.1.v201112150204-238534.

Thanks,
Pete Soheil
DigiOz Multimedia
www.digioz.com

---------------------------------------------

Server API Info:
----------------
Username: student
Password: password
API URL:  http://yamba.marakana.com/api

Useful Commands:
----------------

> cd C:\Users\[YourUsername]\android-sdks\platform-tools

read log file for debugging:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> adb logcat

> adb pull /sdcard/Yamba.trace
> adb shell
> traceview Yamba.trace

From adb shell (you have to be in "cd data/data/com.digioz.yamba/databases/" to query):

>sqlite3 timeline.db (database name + .db)
sqlite> .help
sqlite> .tables
sqlite> .schema
sqlite> select * from statuses;
sqlite> .quit

To do a SQL Dump:

sqlite> .dump
sqlite> select count(*) from statuses;

