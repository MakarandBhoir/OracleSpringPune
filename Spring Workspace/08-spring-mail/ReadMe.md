mvn clean compile
mvn exec:java -Dexec.mainClass="com.oracle.App"
----------------------------------------------------

To generate 16 digit password
--------------------------------
Step-by-Step:
Enable 2-Step Verification
Go to: https://myaccount.google.com/security
Enable 2-Step Verification (if not already enabled).

Generate an App Password
Go to: https://myaccount.google.com/apppasswords
Choose "Mail" for the app and "Other" or "Windows Computer" as the device.
It will give you a 16-character password (e.g., abcd efgh ijkl mnop)