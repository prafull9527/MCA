SLIP-1
1.1.Write a multithreading program in java to display all the vowels from a given String.
class VowelThread extends Thread
{
private String input;
public VowelThread(String input)
{
this.input = input;
}
public void run()
{
System.out.println("Vowels in the string:");
for (int i = 0; i < input.length(); i++) {
char ch = Character.toLowerCase(input.charAt(i));
if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
{
System.out.print(ch + " ");
}
}
}
}
public class VowelFinder
{
public static void main(String[] args)
{
String str = "Multithreading in Java";
VowelThread vt = new VowelThread(str);
vt.start();
}
}
1.2.Write a Program to make use of following JSP implicit objects:
out: To display current Date and Time.
request: To get header information.
response: To Add Cookie
<%@ page import="java.util.Date" %>
<%
// i. 'out' - Display current date and time
Date currentDate = new Date();
out.println("<h3>Current Date and Time: " + currentDate + "</h3>");
// ii. 'request' - Get header information
String userAgent = request.getHeader("User-Agent");
out.println("<h3>User-Agent: " + userAgent + "</h3>");
// iii. 'response' - Add a cookie
javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("user", "JSPUser");
cookie.setMaxAge(3600); // 1 hour
response.addCookie(cookie);
out.println("<h3>Cookie named 'user' added successfully!</h3>");
%>
SLIP-2
2.1. Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2 seconds.
public class Alph extends Thread
{
public void run()
{
for (char c = 'A'; c <= 'Z'; c++)
{
System.out.println(c);
try
{
Thread.sleep(2000); // 2-second delay
} catch (InterruptedException e)
{
e.printStackTrace();
}
}
}
public static void main(String[] args)
{
Alph t = new Alph();
t.start();
}
}
2.2. Write a Java program using Runnable interface to blink Text on the frame.
import java.awt.*;
import java.awt.event.*;
public class BlinkText extends Frame implements Runnable
{
Thread t;
Label l1;
int f;
public BlinkText()
{
t=new Thread(this);
t.start();
setLayout(null);
l1=new Label("Hello JAVA");
l1.setBounds(100,100,100,40);
add(l1);
setSize(300,300);
setVisible(true);
f=0;
}
public void run()
{
try
{
if(f==0)
{
t.sleep(200);
l1.setText("");
f=1;
}
if(f==1)
{
t.sleep(200);
l1.setText("Hello Java");
f=0;
}
}catch(Exception e)
{
System.out.println(e);
}
run();
}
public static void main(String args[])
{
new BlinkText();
}
}
SLIP-3
3.1. Define a thread called “PrintText_Thread” for printing text on command prompt for n number of times.
Create three threads and run them. Pass the text and n as parameters to the thread constructor. Example:
i. First thread prints “I am in FY” 10 times
ii.Second thread prints “I am in SY” 20 times
iii. Third thread prints “I am in TY” 30 times
class PrintText_Thread extends Thread {
private String text;
private int count;
public PrintText_Thread(String text, int count) {
this.text = text;
this.count = count;
}
public void run() {
for (int i = 1; i <= count; i++) {
System.out.println(text);
}
}
}
public class Main {
public static void main(String[] args) {
// Create three threads with different texts and counts
PrintText_Thread t1 = new PrintText_Thread("I am in FY", 10);
PrintText_Thread t2 = new PrintText_Thread("I am in SY", 20);
PrintText_Thread t3 = new PrintText_Thread("I am in TY", 30);
// Start all threads
t1.start();
t2.start();
t3.start();
}
}
3.2. Write a servlet program to display current date and time of server.
import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class DateTimeServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {
// Set content type
response.setContentType("text/html");
// Get writer
PrintWriter out = response.getWriter();
// Get current date and time
Date currentDate = new Date();
// Display result
out.println("<html><body>");
out.println("<h2>Current Server Date and Time:</h2>");
out.println("<h3>" + currentDate.toString() + "</h3>");
out.println("</body></html>");
}
}
SLIP-4
4.1. Write a client-server program which displays the server machine’s date and time on the client Machine.
SERVER.JAVA
import java.io.*;
import java.net.*;
import java.util.Date;
public class Server {
public static void main(String[] args) {
try {
ServerSocket serverSocket = new ServerSocket(5000);
System.out.println("Server is running and waiting for client...");
Socket socket = serverSocket.accept();
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
Date currentDate = new Date();
out.println("Current Server Date and Time: " + currentDate.toString());
socket.close();
serverSocket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
CLIENT.JAVA
import java.io.*;
import java.net.*;
public class Client {
public static void main(String[] args) {
try {
Socket socket = new Socket("localhost", 5000);
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String serverDateTime = in.readLine();
System.out.println("Received from Server: " + serverDateTime);
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
4.2. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.
import java.sql.*;
public class DONOR {
public static void main(String[] args) {
try {
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
"postgres", "dsk");
Statement stmt = null;
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from donor");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("\t-------------------------------------------------");
int count = rsmd.getColumnCount();
System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
System.out.println("\t-------------------------------------------------");
for (int i = 1; i <= count; i++)
{
System.out.println("\t\tColumn No : " + i);
System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
System.out.println();
} // for
System.out.println("\t--------------------------------------------------");
rs.close();
stmt.close();
conn.close();
} // try
catch (Exception e) {
System.out.println(e);
} // catch
}
}
SLIP-5
5.1. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.
import java.sql.*;
public class DONOR {
public static void main(String[] args) {
try {
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
"postgres", "dsk");
Statement stmt = null;
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from donor");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("\t-------------------------------------------------");
int count = rsmd.getColumnCount();
System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
System.out.println("\t-------------------------------------------------");
for (int i = 1; i <= count; i++)
{
System.out.println("\t\tColumn No : " + i);
System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
System.out.println();
} // for
System.out.println("\t--------------------------------------------------");
rs.close();
stmt.close();
conn.close();
} // try
catch (Exception e) {
System.out.println(e);
} // catch
}
}
5.2. Write a java program to simulate traffic signal using threads.
import java.applet.Applet;
import java.awt.*;
public class TrafficSignal extends Applet implements Runnable {
Thread t;
int signal = 0; // 0 = Red, 1 = Yellow, 2 = Green
public void init() {
t = new Thread(this);
t.start();
}
public void run() {
while (true) {
try {
repaint();
Thread.sleep(2000); // 2 seconds per signal
signal = (signal + 1) % 3; // Cycle through signals
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
public void paint(Graphics g) {
// Draw signal box
g.drawRect(100, 100, 100, 300);
// Red Light
if (signal == 0) {
g.setColor(Color.red);
g.fillOval(100, 100, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 200, 100, 100);
g.drawOval(100, 300, 100, 100);
}
// Yellow Light
else if (signal == 1) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.setColor(Color.yellow);
g.fillOval(100, 200, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 300, 100, 100);
}
// Green Light
else if (signal == 2) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.drawOval(100, 200, 100, 100);
g.setColor(Color.green);
g.fillOval(100, 300, 100, 100);
}
}
}
SLIP-6
6.1. Write a servlet program to display current date and time of server.
import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class DateTimeServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {
// Set content type
response.setContentType("text/html");
// Get writer
PrintWriter out = response.getWriter();
// Get current date and time
Date currentDate = new Date();
// Display result
out.println("<html><body>");
out.println("<h2>Current Server Date and Time:</h2>");
out.println("<h3>" + currentDate.toString() + "</h3>");
out.println("</body></html>");
}
}
6.2. Create a JSP page to accept a number from an user and display it in words: Example: 123 –One Two
Three. The output should be in red color.
NumberWord.html
<html>
<body>
<form method=get action="NumberWord.jsp">
Enter Any Number : <input type=text name=num><br><br>
<input type=submit value="Display">
</form>
<body>
</html>
NumberWord.jsp
<html>
<body>
<font color=red>
<%! int i,n;
String s1;
%>
<% s1=request.getParameter("num");
n=s1.length();
i=0;
do
{
char ch=s1.charAt(i);
switch(ch)
{
case '0': out.println("Zero ");break;
case '1': out.println("One ");break;
case '2': out.println("Two ");break;
case '3': out.println("Three ");break;
case '4': out.println("Four ");break;
case '5': out.println("Five ");break;
case '6': out.println("Six ");break;
case '7': out.println("Seven ");break;
case '8': out.println("Eight ");break;
case '9': out.println("Nine ");break;
}
i++;
}while(i<n);
%>
</font>
</body>
</html>
SLIP-7
7.1. Create a JSP page to accept a number from an user and display it in words: Example: 123 –One Two
Three. The output should be in red color.
NumberWord.html
<html>
<body>
<form method=get action="NumberWord.jsp">
Enter Any Number : <input type=text name=num><br><br>
<input type=submit value="Display">
</form>
<body>
</html>
NumberWord.jsp
<html>
<body>
<font color=red>
<%! int i,n;
String s1;
%>
<% s1=request.getParameter("num");
n=s1.length();
i=0;
do
{
char ch=s1.charAt(i);
switch(ch)
{
case '0': out.println("Zero ");break;
case '1': out.println("One ");break;
case '2': out.println("Two ");break;
case '3': out.println("Three ");break;
case '4': out.println("Four ");break;
case '5': out.println("Five ");break;
case '6': out.println("Six ");break;
case '7': out.println("Seven ");break;
case '8': out.println("Eight ");break;
case '9': out.println("Nine ");break;
}
i++;
}while(i<n);
%>
</font>
</body>
</html>
7.2. Write a JDBC program to create Student(rollno, sname, class, percentage) table and insert the records in
the table by accepting the details from user
import java.sql.*;
import java.io.*;
public class Student {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Connection con;
PreparedStatement ps;
Statement st;
ResultSet rs;
// Constructor to load driver and establish connection
Student() {
try {
Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection(
"jdbc:postgresql://server2/exam9", "exam9", "exam9"
);
System.out.println("Connection successful");
} catch (Exception e) {
System.out.println("Error in connection: " + e);
}
}
// Method to insert student record
void insert() throws Exception {
System.out.print("Enter Roll No: ");
int rno = Integer.parseInt(br.readLine());
System.out.print("Enter Name: ");
String name = br.readLine();
System.out.print("Enter Percentage: ");
float per = Float.parseFloat(br.readLine());
String sql = "INSERT INTO student VALUES (?, ?, ?)";
ps = con.prepareStatement(sql);
ps.setInt(1, rno);
ps.setString(2, name);
ps.setFloat(3, per);
int n = ps.executeUpdate();
if (n > 0) {
System.out.println("Record Inserted...");
}
}
// Method to view all student records
void view() throws Exception {
String sql = "SELECT * FROM student";
st = con.createStatement();
rs = st.executeQuery(sql);
System.out.println("\nRollNo\tName\tPercentage");
while (rs.next()) {
System.out.println(
rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3)
);
}
}
// Main method
public static void main(String args[]) {
try {
Student s1 = new Student();
s1.insert();
s1.view();
} catch (Exception e) {
e.printStackTrace();
}
}
}
SLIP-8
8.1. Write a JDBC program to create Student(rollno, sname, class, percentage) table and insert the records in
the table by accepting the details from user
import java.sql.*;
import java.io.*;
public class Student {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Connection con;
PreparedStatement ps;
Statement st;
ResultSet rs;
// Constructor to load driver and establish connection
Student() {
try {
Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection(
"jdbc:postgresql://server2/exam9", "exam9", "exam9"
);
System.out.println("Connection successful");
} catch (Exception e) {
System.out.println("Error in connection: " + e);
}
}
// Method to insert student record
void insert() throws Exception {
System.out.print("Enter Roll No: ");
int rno = Integer.parseInt(br.readLine());
System.out.print("Enter Name: ");
String name = br.readLine();
System.out.print("Enter Percentage: ");
float per = Float.parseFloat(br.readLine());
String sql = "INSERT INTO student VALUES (?, ?, ?)";
ps = con.prepareStatement(sql);
ps.setInt(1, rno);
ps.setString(2, name);
ps.setFloat(3, per);
int n = ps.executeUpdate();
if (n > 0) {
System.out.println("Record Inserted...");
}
}
// Method to view all student records
void view() throws Exception {
String sql = "SELECT * FROM student";
st = con.createStatement();
rs = st.executeQuery(sql);
System.out.println("\nRollNo\tName\tPercentage");
while (rs.next()) {
System.out.println(
rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3)
);
}
}
// Main method
public static void main(String args[]) {
try {
Student s1 = new Student();
s1.insert();
s1.view();
} catch (Exception e) {
e.printStackTrace();
}
}
}
8.2. Write a multithreading program in java to display all the vowels from a given String
class VowelThread extends Thread
{
private String input;
public VowelThread(String input)
{
this.input = input;
}
public void run()
{
System.out.println("Vowels in the string:");
for (int i = 0; i < input.length(); i++) {
char ch = Character.toLowerCase(input.charAt(i));
if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
{
System.out.print(ch + " ");
}
}
}
}
public class VowelFinder
{
public static void main(String[] args)
{
String str = "Multithreading in Java";
VowelThread vt = new VowelThread(str);
vt.start();
}
}
SLIP-9
9.1. Write a java program to simulate traffic signal using threads.
import java.applet.Applet;
import java.awt.*;
public class TrafficSignal extends Applet implements Runnable {
Thread t;
int signal = 0; // 0 = Red, 1 = Yellow, 2 = Green
public void init() {
t = new Thread(this);
t.start();
}
public void run() {
while (true) {
try {
repaint();
Thread.sleep(2000); // 2 seconds per signal
signal = (signal + 1) % 3; // Cycle through signals
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
public void paint(Graphics g) {
// Draw signal box
g.drawRect(100, 100, 100, 300);
// Red Light
if (signal == 0) {
g.setColor(Color.red);
g.fillOval(100, 100, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 200, 100, 100);
g.drawOval(100, 300, 100, 100);
}
// Yellow Light
else if (signal == 1) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.setColor(Color.yellow);
g.fillOval(100, 200, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 300, 100, 100);
}
// Green Light
else if (signal == 2) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.drawOval(100, 200, 100, 100);
g.setColor(Color.green);
g.fillOval(100, 300, 100, 100);
}
}
}
9.2. Create a JSP page to accept a number from an user and display it in words: Example: 123 –One Two
Three. The output should be in red color.
NumberWord.html
<html>
<body>
<form method=get action="NumberWord.jsp">
Enter Any Number : <input type=text name=num><br><br>
<input type=submit value="Display">
</form>
<body>
</html>
NumberWord.jsp
<html>
<body>
<font color=red>
<%! int i,n;
String s1;
%>
<% s1=request.getParameter("num");
n=s1.length();
i=0;
do
{
char ch=s1.charAt(i);
switch(ch)
{
case '0': out.println("Zero ");break;
case '1': out.println("One ");break;
case '2': out.println("Two ");break;
case '3': out.println("Three ");break;
case '4': out.println("Four ");break;
case '5': out.println("Five ");break;
case '6': out.println("Six ");break;
case '7': out.println("Seven ");break;
case '8': out.println("Eight ");break;
case '9': out.println("Nine ");break;
}
i++;
}while(i<n);
%>
</font>
</body>
</html>
SLIP-10
10.1. Write a client-server program which displays the server machine’s date and time on the client Machine.
SERVER.JAVA
import java.io.*;
import java.net.*;
import java.util.Date;
public class Server {
public static void main(String[] args) {
try {
ServerSocket serverSocket = new ServerSocket(5000);
System.out.println("Server is running and waiting for client...");
Socket socket = serverSocket.accept();
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
Date currentDate = new Date();
out.println("Current Server Date and Time: " + currentDate.toString());
socket.close();
serverSocket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
CLIENT.JAVA
import java.io.*;
import java.net.*;
public class Client {
public static void main(String[] args) {
try {
Socket socket = new Socket("localhost", 5000);
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String serverDateTime = in.readLine();
System.out.println("Received from Server: " + serverDateTime);
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
10.2. Write a servlet program to display current date and time of server.
import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class DateTimeServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {
// Set content type
response.setContentType("text/html");
// Get writer
PrintWriter out = response.getWriter();
// Get current date and time
Date currentDate = new Date();
// Display result
out.println("<html><body>");
out.println("<h2>Current Server Date and Time:</h2>");
out.println("<h3>" + currentDate.toString() + "</h3>");
out.println("</body></html>");
}
}
SLIP-11
11.1. Write a Java program using Runnable interface to blink Text on the frame.
import java.awt.*;
import java.awt.event.*;
public class BlinkText extends Frame implements Runnable
{
Thread t;
Label l1;
int f;
public BlinkText()
{
t=new Thread(this);
t.start();
setLayout(null);
l1=new Label("Hello JAVA");
l1.setBounds(100,100,100,40);
add(l1);
setSize(300,300);
setVisible(true);
f=0;
}
public void run()
{
try
{
if(f==0)
{
t.sleep(200);
l1.setText("");
f=1;
}
if(f==1)
{
t.sleep(200);
l1.setText("Hello Java");
f=0;
}
}catch(Exception e)
{
System.out.println(e);
}
run();
}
public static void main(String args[])
{
new BlinkText();
}
}
11.2. Write a servlet program to display current date and time of server.
import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class DateTimeServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {
// Set content type
response.setContentType("text/html");
// Get writer
PrintWriter out = response.getWriter();
// Get current date and time
Date currentDate = new Date();
// Display result
out.println("<html><body>");
out.println("<h2>Current Server Date and Time:</h2>");
out.println("<h3>" + currentDate.toString() + "</h3>");
out.println("</body></html>");
}
}
SLIP-12
12.1. Write a client-server program which displays the server machine’s date and time on the client Machine.
SERVER.JAVA
import java.io.*;
import java.net.*;
import java.util.Date;
public class Server {
public static void main(String[] args) {
try {
ServerSocket serverSocket = new ServerSocket(5000);
System.out.println("Server is running and waiting for client...");
Socket socket = serverSocket.accept();
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
Date currentDate = new Date();
out.println("Current Server Date and Time: " + currentDate.toString());
socket.close();
serverSocket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
CLIENT.JAVA
import java.io.*;
import java.net.*;
public class Client {
public static void main(String[] args) {
try {
Socket socket = new Socket("localhost", 5000);
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String serverDateTime = in.readLine();
System.out.println("Received from Server: " + serverDateTime);
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
12.2. Create a JSP page to accept a number from an user and display it in words: Example: 123 –One Two
Three. The output should be in red color.
NumberWord.html
<html>
<body>
<form method=get action="NumberWord.jsp">
Enter Any Number : <input type=text name=num><br><br>
<input type=submit value="Display">
</form>
<body>
</html>
NumberWord.jsp
<html>
<body>
<font color=red>
<%! int i,n;
String s1;
%>
<% s1=request.getParameter("num");
n=s1.length();
i=0;
do
{
char ch=s1.charAt(i);
switch(ch)
{
case '0': out.println("Zero ");break;
case '1': out.println("One ");break;
case '2': out.println("Two ");break;
case '3': out.println("Three ");break;
case '4': out.println("Four ");break;
case '5': out.println("Five ");break;
case '6': out.println("Six ");break;
case '7': out.println("Seven ");break;
case '8': out.println("Eight ");break;
case '9': out.println("Nine ");break;
}
i++;
}while(i<n);
%>
</font>
</body>
</html>
SLIP-13
13.1. Write a program which sends the name of a text file from the client to server and displays the contents
of the file on the client machine. If the file is not found, display an error message.
SERVER CODE
import java.io.*;
import java.net.*;
public class FileServer {
public static void main(String[] args) throws IOException {
ServerSocket ss = new ServerSocket(5000);
System.out.println("Server started. Waiting for client...");
Socket s = ss.accept();
System.out.println("Client connected.");
BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintWriter out = new PrintWriter(s.getOutputStream(), true);
String fileName = in.readLine();
File file = new File(fileName);
if (file.exists()) {
BufferedReader fileReader = new BufferedReader(new FileReader(file));
String line;
while ((line = fileReader.readLine()) != null) {
out.println(line);
}
fileReader.close();
} else {
out.println("Error: File not found.");
}
s.close();
ss.close();
}
}
CLIENT CODE
import java.io.*;
import java.net.*;
public class FileClient {
public static void main(String[] args) throws IOException {
Socket s = new Socket("localhost", 5000);
BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintWriter out = new PrintWriter(s.getOutputStream(), true);
System.out.print("Enter file name to read: ");
String fileName = userInput.readLine();
out.println(fileName);
String line;
System.out.println("\n--- File Contents ---");
while ((line = in.readLine()) != null) {
System.out.println(line);
}
s.close();
}
}
13.2. Write a Program to make use of following JSP implicit objects:
out: To display current Date and Time.
request: To get header information.
response: To Add Cookie
<%@ page import="java.util.Date" %>
<%
// i. 'out' - Display current date and time
Date currentDate = new Date();
out.println("<h3>Current Date and Time: " + currentDate + "</h3>");
// ii. 'request' - Get header information
String userAgent = request.getHeader("User-Agent");
out.println("<h3>User-Agent: " + userAgent + "</h3>");
// iii. 'response' - Add a cookie
javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("user", "JSPUser");
cookie.setMaxAge(3600); // 1 hour
response.addCookie(cookie);
out.println("<h3>Cookie named 'user' added successfully!</h3>");
%>
SLIP-14
14.1. Define a thread called “PrintText_Thread” for printing text on command prompt for n number of times.
Create three threads and run them. Pass the text and n as parameters to the thread constructor. Example:
i. First thread prints “I am in FY” 10 times
ii.Second thread prints “I am in SY” 20 times
iii. Third thread prints “I am in TY” 30 times
class PrintText_Thread extends Thread {
private String text;
private int count;
public PrintText_Thread(String text, int count) {
this.text = text;
this.count = count;
}
public void run() {
for (int i = 1; i <= count; i++) {
System.out.println(text);
}
}
}
public class Main {
public static void main(String[] args) {
// Create three threads with different texts and counts
PrintText_Thread t1 = new PrintText_Thread("I am in FY", 10);
PrintText_Thread t2 = new PrintText_Thread("I am in SY", 20);
PrintText_Thread t3 = new PrintText_Thread("I am in TY", 30);
// Start all threads
t1.start();
t2.start();
t3.start();
}
}
14.2. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.
import java.sql.*;
public class DONOR {
public static void main(String[] args) {
try {
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
"postgres", "dsk");
Statement stmt = null;
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from donor");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("\t-------------------------------------------------");
int count = rsmd.getColumnCount();
System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
System.out.println("\t-------------------------------------------------");
for (int i = 1; i <= count; i++)
{
System.out.println("\t\tColumn No : " + i);
System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
System.out.println();
} // for
System.out.println("\t--------------------------------------------------");
rs.close();
stmt.close();
conn.close();
} // try
catch (Exception e) {
System.out.println(e);
} // catch
}
}
SLIP-15
15.1.Create a JSP page to accept a number from an user and display it in words: Example: 123 –One Two
Three. The output should be in red color.
NumberWord.html
<html>
<body>
<form method=get action="NumberWord.jsp">
Enter Any Number : <input type=text name=num><br><br>
<input type=submit value="Display">
</form>
<body>
</html>
NumberWord.jsp
<html>
<body>
<font color=red>
<%! int i,n;
String s1;
%>
<% s1=request.getParameter("num");
n=s1.length();
i=0;
do
{
char ch=s1.charAt(i);
switch(ch)
{
case '0': out.println("Zero ");break;
case '1': out.println("One ");break;
case '2': out.println("Two ");break;
case '3': out.println("Three ");break;
case '4': out.println("Four ");break;
case '5': out.println("Five ");break;
case '6': out.println("Six ");break;
case '7': out.println("Seven ");break;
case '8': out.println("Eight ");break;
case '9': out.println("Nine ");break;
}
i++;
}while(i<n);
%>
</font>
</body>
</html>
15.2. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.
import java.sql.*;
public class DONOR {
public static void main(String[] args) {
try {
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
"postgres", "dsk");
Statement stmt = null;
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from donor");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("\t-------------------------------------------------");
int count = rsmd.getColumnCount();
System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
System.out.println("\t-------------------------------------------------");
for (int i = 1; i <= count; i++)
{
System.out.println("\t\tColumn No : " + i);
System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
System.out.println();
} // for
System.out.println("\t--------------------------------------------------");
rs.close();
stmt.close();
conn.close();
} // try
catch (Exception e) {
System.out.println(e);
} // catch
}
}
SLIP-16
16.1. Write a java program to simulate traffic signal using threads.
import java.applet.Applet;
import java.awt.*;
public class TrafficSignal extends Applet implements Runnable {
Thread t;
int signal = 0; // 0 = Red, 1 = Yellow, 2 = Green
public void init() {
t = new Thread(this);
t.start();
}
public void run() {
while (true) {
try {
repaint();
Thread.sleep(2000); // 2 seconds per signal
signal = (signal + 1) % 3; // Cycle through signals
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
public void paint(Graphics g) {
// Draw signal box
g.drawRect(100, 100, 100, 300);
// Red Light
if (signal == 0) {
g.setColor(Color.red);
g.fillOval(100, 100, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 200, 100, 100);
g.drawOval(100, 300, 100, 100);
}
// Yellow Light
else if (signal == 1) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.setColor(Color.yellow);
g.fillOval(100, 200, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 300, 100, 100);
}
// Green Light
else if (signal == 2) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.drawOval(100, 200, 100, 100);
g.setColor(Color.green);
g.fillOval(100, 300, 100, 100);
}
}
}
16.2. Write a program to find primary IP address of the host name which you passed as a parameter
SERVER CODE
import java.io.*;
import java.net.*;
public class SimpleServer {
public static void main(String[] args) throws IOException {
ServerSocket serverSocket = new ServerSocket(5000);
System.out.println("Server is running... Waiting for client.");
Socket socket = serverSocket.accept();
System.out.println("Client connected.");
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
String clientMsg = in.readLine();
System.out.println("Received from client: " + clientMsg);
out.println("Hello from Server!");
socket.close();
serverSocket.close();
}
}
CLIENT CODE
import java.io.*;
import java.net.*;
public class SimpleClient {
public static void main(String[] args) throws IOException {
Socket socket = new Socket("localhost", 5000);
BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
System.out.print("Enter message for server: ");
String message = userInput.readLine();
out.println(message);
String serverReply = in.readLine();
System.out.println("Server says: " + serverReply);
socket.close();
}
}
SLIP-17
17.1. Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2 seconds.
public class Alph extends Thread
{
public void run()
{
for (char c = 'A'; c <= 'Z'; c++)
{
System.out.println(c);
try
{
Thread.sleep(2000); // 2-second delay
} catch (InterruptedException e)
{
e.printStackTrace();
}
}
}
public static void main(String[] args)
{
Alph t = new Alph();
t.start();
}
}
17.2. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.
import java.sql.*;
public class DONOR {
public static void main(String[] args) {
try {
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
"postgres", "dsk");
Statement stmt = null;
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from donor");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("\t-------------------------------------------------");
int count = rsmd.getColumnCount();
System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
System.out.println("\t-------------------------------------------------");
for (int i = 1; i <= count; i++)
{
System.out.println("\t\tColumn No : " + i);
System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
System.out.println();
} // for
System.out.println("\t--------------------------------------------------");
rs.close();
stmt.close();
conn.close();
} // try
catch (Exception e) {
System.out.println(e);
} // catch
}
}
SLIP-18
18.1. Write a servlet program to display current date and time of server.
import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class DateTimeServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {
// Set content type
response.setContentType("text/html");
// Get writer
PrintWriter out = response.getWriter();
// Get current date and time
Date currentDate = new Date();
// Display result
out.println("<html><body>");
out.println("<h2>Current Server Date and Time:</h2>");
out.println("<h3>" + currentDate.toString() + "</h3>");
out.println("</body></html>");
}
}
18.2. Write a JDBC program to create Student(rollno, sname, class, percentage) table and insert the records in
the table by accepting the details from user
import java.sql.*;
import java.io.*;
public class Student {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Connection con;
PreparedStatement ps;
Statement st;
ResultSet rs;
// Constructor to load driver and establish connection
Student() {
try {
Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection(
"jdbc:postgresql://server2/exam9", "exam9", "exam9"
);
System.out.println("Connection successful");
} catch (Exception e) {
System.out.println("Error in connection: " + e);
}
}
// Method to insert student record
void insert() throws Exception {
System.out.print("Enter Roll No: ");
int rno = Integer.parseInt(br.readLine());
System.out.print("Enter Name: ");
String name = br.readLine();
System.out.print("Enter Percentage: ");
float per = Float.parseFloat(br.readLine());
String sql = "INSERT INTO student VALUES (?, ?, ?)";
ps = con.prepareStatement(sql);
ps.setInt(1, rno);
ps.setString(2, name);
ps.setFloat(3, per);
int n = ps.executeUpdate();
if (n > 0) {
System.out.println("Record Inserted...");
}
}
// Method to view all student records
void view() throws Exception {
String sql = "SELECT * FROM student";
st = con.createStatement();
rs = st.executeQuery(sql);
System.out.println("\nRollNo\tName\tPercentage");
while (rs.next()) {
System.out.println(
rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3)
);
}
}
// Main method
public static void main(String args[]) {
try {
Student s1 = new Student();
s1.insert();
s1.view();
} catch (Exception e) {
e.printStackTrace();
}
}
}
SLIP-19
19.1. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.
import java.sql.*;
public class DONOR {
public static void main(String[] args) {
try {
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
"postgres", "dsk");
Statement stmt = null;
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from donor");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("\t-------------------------------------------------");
int count = rsmd.getColumnCount();
System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
System.out.println("\t-------------------------------------------------");
for (int i = 1; i <= count; i++)
{
System.out.println("\t\tColumn No : " + i);
System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
System.out.println();
} // for
System.out.println("\t--------------------------------------------------");
rs.close();
stmt.close();
conn.close();
} // try
catch (Exception e) {
System.out.println(e);
} // catch
}
}
19.2. Write a java program to simulate traffic signal using threads.
import java.applet.Applet;
import java.awt.*;
public class TrafficSignal extends Applet implements Runnable {
Thread t;
int signal = 0; // 0 = Red, 1 = Yellow, 2 = Green
public void init() {
t = new Thread(this);
t.start();
}
public void run() {
while (true) {
try {
repaint();
Thread.sleep(2000); // 2 seconds per signal
signal = (signal + 1) % 3; // Cycle through signals
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
public void paint(Graphics g) {
// Draw signal box
g.drawRect(100, 100, 100, 300);
// Red Light
if (signal == 0) {
g.setColor(Color.red);
g.fillOval(100, 100, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 200, 100, 100);
g.drawOval(100, 300, 100, 100);
}
// Yellow Light
else if (signal == 1) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.setColor(Color.yellow);
g.fillOval(100, 200, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 300, 100, 100);
}
// Green Light
else if (signal == 2) {
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.drawOval(100, 200, 100, 100);
g.setColor(Color.green);
g.fillOval(100, 300, 100, 100);
}
}
}
SLIP-20
20.1. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.
import java.sql.*;
public class DONOR {
public static void main(String[] args) {
try {
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
"postgres", "dsk");
Statement stmt = null;
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from donor");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("\t-------------------------------------------------");
int count = rsmd.getColumnCount();
System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
System.out.println("\t-------------------------------------------------");
for (int i = 1; i <= count; i++)
{
System.out.println("\t\tColumn No : " + i);
System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
System.out.println();
} // for
System.out.println("\t--------------------------------------------------");
rs.close();
stmt.close();
conn.close();
} // try
catch (Exception e) {
System.out.println(e);
} // catch
}
}
20.2. Create a JSP page to accept a number from an user and display it in words: Example: 123 –One Two
Three. The output should be in red color.
NumberWord.html
<html>
<body>
<form method=get action="NumberWord.jsp">
Enter Any Number : <input type=text name=num><br><br>
<input type=submit value="Display">
</form>
<body>
</html>
NumberWord.jsp
<html>
<body>
<font color=red>
<%! int i,n;
String s1;
%>
<% s1=request.getParameter("num");
n=s1.length();
i=0;
do
{
char ch=s1.charAt(i);
switch(ch)
{
case '0': out.println("Zero ");break;
case '1': out.println("One ");break;
case '2': out.println("Two ");break;
case '3': out.println("Three ");break;
case '4': out.println("Four ");break;
case '5': out.println("Five ");break;
case '6': out.println("Six ");break;
case '7': out.println("Seven ");break;
case '8': out.println("Eight ");break;
case '9': out.println("Nine ");break;
}
i++;
}while(i<n);
%>
</font>
</body>
</html>
SLIP-21
21.1. Define a thread called “PrintText_Thread” for printing text on command prompt for n number of times.
Create three threads and run them. Pass the text and n as parameters to the thread constructor. Example:
i. First thread prints “I am in FY” 10 times
ii.Second thread prints “I am in SY” 20 times
iii. Third thread prints “I am in TY” 30 times
class PrintText_Thread extends Thread {
private String text;
private int count;
public PrintText_Thread(String text, int count) {
this.text = text;
this.count = count;
}
public void run() {
for (int i = 1; i <= count; i++) {
System.out.println(text);
}
}
}
public class Main {
public static void main(String[] args) {
// Create three threads with different texts and counts
PrintText_Thread t1 = new PrintText_Thread("I am in FY", 10);
PrintText_Thread t2 = new PrintText_Thread("I am in SY", 20);
PrintText_Thread t3 = new PrintText_Thread("I am in TY", 30);
// Start all threads
t1.start();
t2.start();
t3.start();
}
}
21.2. Write a JSP program to display number of times user has visited the page. (Use cookies)
<%@ page import="javax.servlet.http.Cookie" %>
<%
int visitCount = 0;
Cookie[] cookies = request.getCookies();
if (cookies != null) {
for (Cookie c : cookies) {
if (c.getName().equals("visitCount")) {
visitCount = Integer.parseInt(c.getValue());
}
}
}
visitCount++;
Cookie visitCookie = new Cookie("visitCount", Integer.toString(visitCount));
visitCookie.setMaxAge(60 * 60 * 24); // 1 day
response.addCookie(visitCookie);
%>
<html>
<head><title>Visit Counter</title></head>
<body>
<h2>You have visited this page <%= visitCount %> time(s).</h2>
</body>
</html>