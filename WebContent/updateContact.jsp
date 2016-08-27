<%@ page language="java" import="java.util.*,entity.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改联系人</title>
<script type="text/javascript">

function clearDiv(max){
	

	 for(var i=1;i<=max;i++){

	 	 var node = document.getElementById(i);
		 if(node.type=='text'){
			 node.value="";
		 }
		 if(node.type=='radio'){
			 node.checked=null;
		 }
	 }
}

</script>
</head>

<body>
<center><h3>修改联系人</h3></center>
<form action="${pageContext.request.contextPath }/UpdateContactServlet" method="post">
<input type="hidden" name="id" value="${contact.id }"/>
<table align="center" border="1" width="300px">
    <tr>
    	<th>姓名</th>
        <td><input id="1" type="text" name="name" value="${contact.name }"/><font color="red">${msg1 }</font><font color="red">${msg2 }</font><font color="red">${msg3 }</font></td>
    </tr>
    <tr>
    	<th>性别</th>
        <td>
        <input id="2" type="radio" name="gender" value="男"  <c:if test="${contact.gender=='男' }">checked="checked"</c:if> />男
        <input id="3" type="radio" name="gender" value="女"  <c:if test="${contact.gender=='女' }">checked="checked"</c:if> />女<font color="red">${msg7 }</font>
        </td>
    </tr>
    <tr>
    	<th>年龄</th>
        <td><input id="4" type="text" name="age" value="${contact.age }"/><font color="red">${msg4 }</font></td>
    </tr>
    <tr>
    	<th>邮箱</th>
        <td><input id="5" type="text" name="email" value="${contact.email }"/><font color="red">${msg5 }</font></td>
    </tr>
    <tr>
    	<th>QQ</th>
        <td><input id="6" type="text" name="qq" value="${contact.qq }"/><font color="red">${msg6 }</font></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
        <input type="submit" value="保存"/>&nbsp;
        <input type="button" value="重置" onclick="clearDiv(6)"/></td>
    </tr>
</table>
</form>
</body>
</html>
