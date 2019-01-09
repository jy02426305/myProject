<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="shiro"  uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript">
        function showDepartment() {
            var status=document.getElementById("departmentCon").style.display;
            if(status=="none"){
                document.getElementById("employeesCon").style.display="none";
                document.getElementById("departmentCon").style.display="block";
            }else{
                document.getElementById("employeesCon").style.display="block";
                document.getElementById("departmentCon").style.display="none";
            }
        }
        function showEmployees() {
            var status=document.getElementById("employeesCon").style.display;
            if(status=="none"){
                document.getElementById("departmentCon").style.display="none";
                document.getElementById("employeesCon").style.display="block";
            }else{
                document.getElementById("departmentCon").style.display="block";
                document.getElementById("employeesCon").style.display="none";
            }
        }
    </script>
</head>
<body>
    <a href="javascript:;" id="employees" onclick="showEmployees();">员工管理</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:;" id="department" onclick="showDepartment();">部门管理</a>
    <br />
<div style="display: none;" id="employeesCon">
    <shiro:hasPermission  name="employee:create">
        <input type="button" id="addEmployees" value="新增" />
    </shiro:hasPermission>
    员工编号：<input type="text" id="employeesNo" />
    <br />
    员工姓名：<input type="text" id="employeesName" />
</div>
<div style="display: none;" id="departmentCon">
    部门名称：<input type="text" id="departmentName" />
</div>
</body>
</html>
