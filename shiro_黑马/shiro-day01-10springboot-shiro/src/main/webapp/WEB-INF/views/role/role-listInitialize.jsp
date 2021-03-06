<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/layouts/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>星心芯平台-角色列表</title>
<%@ include file="/WEB-INF/layouts/meta.jsp" %>
<%@ include file="/WEB-INF/layouts/header.jsp" %>
<script type="text/javascript" src="${ctx}/static/js/role/role-initialize.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',split:false,title:'查询条件'"  style="height:90px;padding:5px; border-width: 0 0 1px 0;">
        <form name="searchForm" id ="searchForm" action="" method="post">
	    <table width="100%" border="0" cellspacing="5" cellpadding="0">
		  <tr>
			<td width="60" class="right_">角色名称</td>
			<td width="130"><input name="roleName" class="txtbox" type="text" style="width:120px"/></td>
			<td width="60" class="right_">角色标识</td>
			<td width="130"><input name="label" class="txtbox"  type="text" style="width:120px"/></td>
			<td width="10" >&nbsp;</td>
			<td width="150">
				<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch('resList',false,false)">查 询</a>&nbsp;&nbsp;
	        	<a  href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-reload'" onclick="doReload('${ctx}/role/listInitialize')" >重 置</a>
			</td>
			<td width="*">&nbsp;</td>
		  </tr>
		</table>
        </form>
	</div>
	<div data-options="region:'center',title:''" >
	 <table id="resList"></table>
    </div>
  
    <div id="toolButton" style="display: none;" >
		<a href="#" id="addbtn" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'" onclick="addDataInfoRefresh('resList','角色添加','${ctx}/role/input',$(document).width()*0.8,$(document).height()*1.1,false,false,false)">新增</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" onclick="updateDataInfoRefresh('resList','角色修改','${ctx}/role/input',$(document).width()*0.8,$(document).height()*1.1,false,false)">修改/查看</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tijiaosh'" onclick='startDataInfoRefresh("resList","${ctx}/role/start",false,false)'>启用</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'" onclick='stopDataInfoRefresh("resList","${ctx}/role/stop",false,false)'>禁用</a>
	</div>
	
	
</div>
</body>
</html>