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