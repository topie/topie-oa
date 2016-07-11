<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>
<%pageContext.setAttribute("currentHeader", "attendance");%>
<%pageContext.setAttribute("currentMenu", "attendance");%>
<!doctype html>
<html lang="en">

  <head>
    <%@include file="/common/meta.jsp"%>
    <title><spring:message code="dev.attendance-info.list.title" text="列表"/></title>
    <%@include file="/common/s3.jsp"%>
    <link type="text/css" rel="stylesheet" href="../widgets/userpicker3/userpicker.css">
    <script type="text/javascript" src="../widgets/userpicker3/userpicker.js"></script>
    <script type="text/javascript" src="../s/jquery/calendar/calendar.js"></script>
    <script type="text/javascript" src="../s/jquery/calendar/WdatePicker.js"></script>
    <link type="text/css" rel="stylesheet" href="../s/jquery/calendar/skin/WdatePicker.css">
    <script type="text/javascript">
var config = {
    id: 'attendance-infoGrid',
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
	gridFormId: 'attendance-infoGridForm',
	exportUrl: 'attendance-info-export.do'
};

var table;

$(function() {
	//table = new Table(config);
    //table.configPagination('.m-pagination');
    //table.configPageInfo('.m-page-info');
    //table.configPageSize('.m-page-size');
    
    createUserPicker({
		modalId: 'userPicker',
		url: '${tenantPrefix}/rs/user/search'
	});
});
    </script>
  </head>

  <body>
    <%@include file="/header/attendance-info.jsp"%>

    <div class="row-fluid">
	  <%@include file="/menu/attendance-info.jsp"%>

	  <!-- start of main -->
      <section id="m-main" class="col-md-10" style="padding-top:65px;">

<div class="panel panel-default">
  <div class="panel-heading">
	<i class="glyphicon glyphicon-list"></i>
    查询
	<div class="pull-right ctrl">
	  <a class="btn btn-xs"><i id="attendance-infoSearchIcon" class="glyphicon glyphicon-chevron-up"></i></a>
    </div>
  </div>
  <div class="panel-body">

		  <form name="attendance-infoForm" method="post" action="account-attendance-list.do" class="form-inline">
		  	 <div class="input-group userPicker" style="width:200px;">
				<input id="_task_name_key" type="hidden" name="userId" class="input-medium" value="">
				<input type="text" class="form-control" name="username" placeholder="" value="">
				<div class="input-group-addon"><i class="glyphicon glyphicon-user"></i></div>
			 </div>
			 <input class="Wdate form-control" name="dateStr" type="text" value="" style="height: 34px;margin-left: 40px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			 <button class="btn btn-default a-search" onclick="document.attendance-infoForm.submit()">查询</button>&nbsp;
			 
		  
		  	<!-- 
		    <label for="attendance-info_name"><spring:message code='attendance-info.attendance-info.list.search.name' text='名称'/>:</label>
		    <input type="text" id="attendance-info_name" name="filter_LIKES_name" value="${param.filter_LIKES_name}" class="form-control">
			<button class="btn btn-default a-search" onclick="document.attendance-infoForm.submit()">查询</button>&nbsp;
			 -->
		  </form>

		</div>
	  </div>

      <div style="margin-bottom: 20px;">
	    <div class="pull-left btn-group" role="group">
		  <button class="btn btn-default a-insert" onclick="location.href='account-attendance-input.do'">新建</button>
		  <button class="btn btn-default a-remove" onclick="table.removeAll()">删除</button>
		  <button class="btn btn-default a-export" onclick="table.exportExcel()">导出</button>
		</div>
		<!-- 
		<div class="pull-right">
		  每页显示
		  <select class="m-page-size form-control" style="display:inline;width:auto;">
		    <option value="10">10</option>
		    <option value="20">20</option>
		    <option value="50">50</option>
		  </select>
		  条
        </div>
		 -->
	    <div class="clearfix"></div>
	  </div>

<form id="attendance-infoGridForm" name="attendance-infoGridForm" method='post' action="account-attendance-remove.do" class="m-form-blank">
      <div class="panel panel-default">
        <div class="panel-heading">
		  <i class="glyphicon glyphicon-list"></i>
		  <spring:message code="scope-info.scope-info.list.title" text="列表"/>
		</div>

  <table id="attendance-infoGrid" class="table table-hover">
    <thead>
      <tr>
        <th width="10" class="table-check"><input type="checkbox" name="checkAll" onchange="toggleSelectedItems(this.checked)"></th>
        <th class="sorting" name="accountName"><spring:message code="attendance-info.attendance-info.list.displayName" text="姓名"/></th>
        <th class="sorting" name="date"><spring:message code="attendance-info.attendance-info.list.dateStr" text="日期"/></th>
        <th class="sorting" name="week"><spring:message code="attendance-info.attendance-info.list.weekStr" text="星期"/></th>
        <th class="sorting" name="shouldAttendance"><spring:message code="attendance-info.attendance-info.list.shouldAttendance" text="应出勤"/></th>
        <th class="sorting" name="realAttendance"><spring:message code="attendance-info.attendance-info.list.realAttendance" text="实出勤"/></th>
        <th class="sorting" name="workStartTime"><spring:message code="attendance-info.attendance-info.list.workStartTime" text="上班打卡时间"/></th>
        <th class="sorting" name="workEndTime"><spring:message code="attendance-info.attendance-info.list.workEndTime" text="下班打卡时间"/></th>
        <th class="sorting" name="offHour"><spring:message code="attendance-info.attendance-info.list.offHour" text="旷工"/></th>
        <th class="sorting" name="vacation"><spring:message code="attendance-info.attendance-info.list.vacation" text="请假"/></th>
        <th width="80">操作</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach items="${list}" var="item">
      <tr>
        <td><input type="checkbox" class="selectedItem a-check" name="selectedItem" value="${item.id}"></td>
        <td>${item.accountInfo.displayName}</td>
        <td>${item.dateStr}</td>
        <td>${item.weekStr}</td>
        <td>${item.shouldAttendance}</td>
        <td>${item.realAttendance}</td>
        <td>${item.workStartTime}</td>
        <td>${item.workEndTime}</td>
        <td>${item.offHour}</td>
        <c:if test="${item.vacation == 0}">
        	<td></td>
        </c:if>
        <c:if test="${item.vacation == 1}">
        	<td>事假</td>
        </c:if>
        <c:if test="${item.vacation == 2}">
        	<td>病假</td>
        </c:if>
        <c:if test="${item.vacation == 3}">
        	<td>年假</td>
        </c:if>
        <c:if test="${item.vacation == 4}">
        	<td>丧假</td>
        </c:if>
        <c:if test="${item.vacation == 5}">
        	<td>看护假</td>
        </c:if>
        <c:if test="${item.vacation == 6}">
        	<td>产假</td>
        </c:if>
        <c:if test="${item.vacation == 7}">
        	<td>婚假</td>
        </c:if>
        <c:if test="${item.vacation == 8}">
        	<td>其他</td>
        </c:if>
        <c:if test="${item.vacation == 9}">
        	<td>外勤出差</td>
        </c:if>
        <td>
          <a href="attendance-info-input.do?id=${item.id}" class="a-update"><spring:message code="core.list.edit" text="编辑"/></a>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>


      </div>
</form>
	  <!-- 
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
	 -->
  </body>

</html>

