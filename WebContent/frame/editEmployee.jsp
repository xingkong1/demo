<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">员工修改</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('postForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:window.history.back();">退回</a>
</td>
</tr>
</table>
<br/>

<s:form id="postForm" action="employee_update.action" method="post">
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名</td>
<td><input type="text" name="ename" value="<s:property value="#session.employee.ename"/>"/></td>
<td>性别</td>
<td><s:radio name="sex" list="{'男','女'}" value="%{#session.employee.sex}" /></td>
</tr>
<tr>
<td>出生日期</td>
<td><input type="text" name="birthday" value="<s:property value="#session.employee.birthday"/>"/></td>
<td>入职时间</td>
<td><input type="text" name="joinDate" value="<s:property value="#session.employee.joinDate"/>"/></td>
</tr>

<tr>
<td>所属部门</td>
<s:select name="department.did" list="#session.departments" value="%{#session.employee.department.did}" listKey="did" listValue="dname" 
headerKey="" headerValue="-请-选-择-" ></s:select>
<td>编号</td>
<td><input type="text" name="eid" value="<s:property value="#session.employee.eid"/>"/></td>
</tr>

</table>
</s:form>

</body>
</html>