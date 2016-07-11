<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>
<%pageContext.setAttribute("currentHeader", "org");%>
<%pageContext.setAttribute("currentMenu", "org");%>
<!doctype html>
<html lang="en">

  <head>
    <%@include file="/common/meta.jsp"%>
    <title><spring:message code="dev.org.list.title" text="列表"/></title>
    <%@include file="/common/s3.jsp"%>
    <script type="text/javascript">
var config = {
    id: 'orgGrid',
    pageNo: ${page.pageNo},
    pageSize: ${page.pageSize},
    totalCount: ${page.totalCount},
    resultSize: ${page.resultSize},
    pageCount: ${page.pageCount},
    orderBy: '${page.orderBy == null ? "" : page.orderBy}',
    asc: ${page.asc},
    params: {
        'filter_LIKES_name': '${param.filter_LIKES_name}'
    },
	selectedItemClass: 'selectedItem',
	gridFormId: 'orgGridForm',
	exportUrl: 'org-export.do'
};


function openUserAddPage(){
	if('${partyEntity}' == ''){
		alert('请先选择部门');
		return;
	}
	window.location.href="${tenantPrefix}/user/account-info-input.do?orgId="+'${partyEntity.id}';
}

var table;

$(function() {
	table = new Table(config);
    table.configPagination('.m-pagination');
    table.configPageInfo('.m-page-info');
    table.configPageSize('.m-page-size');
});

function delAccount(id,orgId){
	if(confirm("确定删除该成员吗?")){
		$.ajax({
             type: "GET",
             url: "${ctx}/user/account-info-remove.do?selectedItem="+id+"&orgId="+orgId,
             dataType: "json",
             success: function(d){
             	alert("删除成功");
             	window.location.href="${tenantPrefix}/party/org-list.do?partyEntityId="+orgId;
             },
             error:function(data){
			 	alert("出错了！！:"+data.msg);
			 }
         });
	}
	return false;
}
    </script>
  </head>

  <body>
    <%@include file="/header/org.jsp"%>

    <div class="row-fluid">
	  <%@include file="/menu/org.jsp"%>

	  <!-- start of main -->
      <section id="m-main" class="col-md-10" style="padding-top:65px;">

<div class="panel panel-default">
  <div class="panel-heading">
	<i class="glyphicon glyphicon-list"></i>
    查询
	<div class="pull-right ctrl">
	  <a class="btn btn-xs"><i id="orgSearchIcon" class="glyphicon glyphicon-chevron-up"></i></a>
    </div>
  </div>
  <div class="panel-body">

		  <form name="orgForm" method="post" action="org-list.do" class="form-inline">
		    <label for="org_name"><spring:message code='org.org.list.search.name' text='名称'/>:</label>
		    <input type="text" id="org_name" name="filter_LIKES_name" value="${param.filter_LIKES_name}" class="form-control">
			<button class="btn btn-default a-search" onclick="document.orgForm.submit()">查询</button>&nbsp;
		  </form>

		</div>
	  </div>

      <div style="margin-bottom: 20px;">
	    <div class="pull-left btn-group" role="group">
	      <!-- 
		  <c:forEach items="${childTypes}" var="item">
		  <button class="btn btn-default a-insert" onclick="location.href='org-input.do?partyStructTypeId=${partyStructTypeId}&partyEntityId=${partyEntityId}&partyTypeId=${item.id}'">新建${item.name}</button>
		  </c:forEach>
		   -->
		   <c:forEach items="${childTypes}" var="item">
		   	<c:if test="${item.name == '人员'}">
		   		<button class="btn btn-default a-insert" onclick="openUserAddPage();">新建成员</button>
		   	</c:if>
		   	<c:if test="${item.name == '部门'}">
		   		<button class="btn btn-default a-insert" onclick="location.href='org-input.do?partyStructTypeId=${partyStructTypeId}&partyEntityId=${partyEntityId}&partyTypeId=${item.id}'">新建${item.name}</button>
		   	</c:if>
		   </c:forEach>
		</div>

		<div class="pull-right">
		  每页显示
		  <select class="m-page-size form-control" style="display:inline;width:auto;">
		    <option value="10">10</option>
		    <option value="20">20</option>
		    <option value="50">50</option>
		  </select>
		  条
        </div>

	    <div class="clearfix"></div>
	  </div>

<form id="orgGridForm" name="orgGridForm" method='post' action="org-remove.do" class="m-form-blank">
      <div class="panel panel-default">
        <div class="panel-heading">
		  <i class="glyphicon glyphicon-list"></i>
		  <spring:message code="scope-info.scope-info.list.title" text="列表"/>
		</div>


  <table id="orgGrid" class="table table-hover">
    <thead>
      <tr>
        <th width="10" class="table-check"><input type="checkbox" name="checkAll" onchange="toggleSelectedItems(this.checked)"/></th>
        <th class="sorting" name="username">账号</th>
        <th class="sorting" name="displayName">姓名</th>
        <th class="sorting" name="cellphone">电话</th>
        <th class="sorting" name="cellphone">地址</th>
        <!-- 
        <th class="sorting" name="partyType">类型</th>
        <th class="sorting" name="admin">管理</th>
         -->
        <th>操作</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach items="${page.result}" var="item">
      <tr>
        <td><input type="checkbox" class="selectedItem" name="selectedItem" value="${item.id}"></td>
        <td>${item.username}</td>
        <td>${item.displayName}</td>
        <td>${item.cellphone}</td>
        <td>${item.address}</td>
        <td>
          <!-- 
          <a href="org-remove.do?selectedItem=${item.id}&partyStructTypeId=${partyStructTypeId}&partyEntityId=${partyEntityId}" class="">删除</a>
		   -->
		  <a href="javascript:void(0)" class="" onclick="delAccount(${item.id},${item.partyEntity.id});">删除</a>
		  <a href="${ctx}/user/account-info-input.do?id=${item.id}&orgId=${item.partyEntity.id}" class="">编辑</a>
		</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>


      </div>
</form>

	  <div>
	    <div class="m-page-info pull-left">
		  共100条记录 显示1到10条记录
		</div>

		<div class="btn-group m-pagination pull-right">
		  <button class="btn btn-default">&lt;</button>
		  <button class="btn btn-default">1</button>
		  <button class="btn btn-default">&gt;</button>
		</div>

	    <div class="clearfix"></div>
      </div>

      <div class="m-spacer"></div>

      </section>
	  <!-- end of main -->
	</div>

  </body>

</html>

