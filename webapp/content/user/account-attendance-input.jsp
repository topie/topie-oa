<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>
<%pageContext.setAttribute("currentHeader", "attendance");%>
<%pageContext.setAttribute("currentMenu", "attendance");%>
<!doctype html>
<html>

  <head>
    <%@include file="/common/meta.jsp"%>
    <title>编辑</title>
    <%@include file="/common/s3.jsp"%>
    <link type="text/css" rel="stylesheet" href="../widgets/userpicker3/userpicker.css">
    <script type="text/javascript" src="../widgets/userpicker3/userpicker.js"></script>
    <script type="text/javascript" src="../s/jquery/calendar/calendar.js"></script>
    <script type="text/javascript" src="../s/jquery/calendar/WdatePicker.js"></script>
    <link type="text/css" rel="stylesheet" href="../s/jquery/calendar/skin/WdatePicker.css">
    <style type="text/css">
    	#inputTable td {
			padding-top: 10px;
			text-align: right;
		}
    </style>
    <script type="text/javascript">
$(function() {
    $("#attendance-infoForm").validate({
        submitHandler: function(form) {
			bootbox.animate(false);
			var box = bootbox.dialog('<div class="progress progress-striped active" style="margin:0px;"><div class="bar" style="width: 100%;"></div></div>');
            form.submit();
        },
        errorClass: 'validate-error'
    });
    
    createUserPicker({
		modalId: 'userPicker',
		url: '${tenantPrefix}/rs/user/search'
	});
})
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
		  编辑
		</div>

		<div class="panel-body">


<form id="attendance-infoForm" method="post" action="account-attendance-save.do" class="form-horizontal">
	<table id="inputTable">
		<tr>
			<td>成员：</td>
			<td>
				<div class="input-group userPicker" style="width:200px;">
					<input id="_task_name_key" type="hidden" name="userId" class="input-medium" value="">
					<input type="text" class="form-control" name="username" required="required" placeholder="" value="">
					<div class="input-group-addon"><i class="glyphicon glyphicon-user"></i></div>
				</div>
			</td>
		</tr>
		<tr>
			<td>日期：</td>
			<td><input class="Wdate form-control" name="dateStr" required="required" type="text" style="height: 34px;width: 200px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
		</tr>
		<tr>
			<td>上班打开时间：</td>
			<td>
				<select style="height: 34px;width: 200px;" name="workStartTime">
				  	<option value="00:30">00:30</option>
				  	<option value="01:00">01:00</option>
				  	<option value="01:30">01:30</option>
				  	<option value="02:00">02:00</option>
				  	<option value="02:30">02:30</option>
				  	<option value="03:00">03:00</option>
				  	<option value="03:30">03:30</option>
				  	<option value="04:00">04:00</option>
				  	<option value="04:30">04:30</option>
				  	<option value="05:00">05:00</option>
				  	<option value="05:30">05:30</option>
				  	<option value="06:00">06:00</option>
				  	<option value="06:30">06:30</option>
				  	<option value="07:00">07:00</option>
				  	<option value="07:30">07:30</option>
				  	<option value="08:00">08:00</option>
				  	<option value="08:30" selected="selected">08:30</option>
				  	<option value="09:00">09:00</option>
				  	<option value="09:30">09:30</option>
				  	<option value="10:00">10:00</option>
				  	<option value="10:30">10:30</option>
				  	<option value="11:00">11:00</option>
				  	<option value="11:30">11:30</option>
				  	<option value="12:00">12:00</option>
				  	<option value="12:30">12:30</option>
				  	<option value="13:00">13:00</option>
				  	<option value="13:30">13:30</option>
				  	<option value="14:00">14:00</option>
				  	<option value="14:30">14:30</option>
				  	<option value="15:00">15:00</option>
				  	<option value="15:30">15:30</option>
				  	<option value="16:00">16:00</option>
				  	<option value="16:30">16:30</option>
				  	<option value="17:00">17:00</option>
				  	<option value="17:30">17:30</option>
				  	<option value="18:00">18:00</option>
				  	<option value="18:30">18:30</option>
				  	<option value="19:00">19:00</option>
				  	<option value="19:30">19:30</option>
				  	<option value="20:00">20:00</option>
				  	<option value="20:30">20:30</option>
				  	<option value="21:00">21:00</option>
				  	<option value="21:30">21:30</option>
				  	<option value="22:00">22:00</option>
				  	<option value="22:30">22:30</option>
				  	<option value="23:00">23:00</option>
				  	<option value="23:30">23:30</option>
				  	<option value="24:00">24:00</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>下班打卡时间：</td>
			<td>
				<select style="height: 34px;width: 200px;" name="workEndTime">
				  	<option value="00:30">00:30</option>
				  	<option value="01:00">01:00</option>
				  	<option value="01:30">01:30</option>
				  	<option value="02:00">02:00</option>
				  	<option value="02:30">02:30</option>
				  	<option value="03:00">03:00</option>
				  	<option value="03:30">03:30</option>
				  	<option value="04:00">04:00</option>
				  	<option value="04:30">04:30</option>
				  	<option value="05:00">05:00</option>
				  	<option value="05:30">05:30</option>
				  	<option value="06:00">06:00</option>
				  	<option value="06:30">06:30</option>
				  	<option value="07:00">07:00</option>
				  	<option value="07:30">07:30</option>
				  	<option value="08:00">08:00</option>
				  	<option value="08:30">08:30</option>
				  	<option value="09:00">09:00</option>
				  	<option value="09:30">09:30</option>
				  	<option value="10:00">10:00</option>
				  	<option value="10:30">10:30</option>
				  	<option value="11:00">11:00</option>
				  	<option value="11:30">11:30</option>
				  	<option value="12:00">12:00</option>
				  	<option value="12:30">12:30</option>
				  	<option value="13:00">13:00</option>
				  	<option value="13:30">13:30</option>
				  	<option value="14:00">14:00</option>
				  	<option value="14:30">14:30</option>
				  	<option value="15:00">15:00</option>
				  	<option value="15:30">15:30</option>
				  	<option value="16:00">16:00</option>
				  	<option value="16:30">16:30</option>
				  	<option value="17:00">17:00</option>
				  	<option value="17:30" selected="selected">17:30</option>
				  	<option value="18:00">18:00</option>
				  	<option value="18:30">18:30</option>
				  	<option value="19:00">19:00</option>
				  	<option value="19:30">19:30</option>
				  	<option value="20:00">20:00</option>
				  	<option value="20:30">20:30</option>
				  	<option value="21:00">21:00</option>
				  	<option value="21:30">21:30</option>
				  	<option value="22:00">22:00</option>
				  	<option value="22:30">22:30</option>
				  	<option value="23:00">23:00</option>
				  	<option value="23:30">23:30</option>
				  	<option value="24:00">24:00</option>
				</select>    
			</td>
		</tr>
	</table>
       
      
  
      
      
      
  
  <div class="form-group">
    <div class="col-sm-5">
      <button type="submit" class="btn a-submit"><spring:message code='core.input.save' text='保存'/></button>
	  &nbsp;
      <button type="button" class="btn a-cancel" onclick="history.back();"><spring:message code='core.input.back' text='返回'/></button>
    </div>
  </div>
</form>

		</div>
      </article>

    </section>
	<!-- end of main -->
	</div>

  </body>

</html>

