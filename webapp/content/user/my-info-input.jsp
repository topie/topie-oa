<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>
<%pageContext.setAttribute("currentHeader", "my");%>
<%pageContext.setAttribute("currentMenu", "my");%>
<!doctype html>
<html lang="en">

  <head>
    <%@include file="/common/meta.jsp"%>
    <title>修改信息</title>
    <%@include file="/common/s3.jsp"%>
    <script type="text/javascript">
$(function() {
    $("#userForm").validate({
        submitHandler: function(form) {
			bootbox.animate(false);
			var box = bootbox.dialog('<div class="progress progress-striped active" style="margin:0px;"><div class="bar" style="width: 100%;"></div></div>');
            form.submit();
        },
        errorClass: 'validate-error'
    });

    $('#myTab a').click(function (e) {
		e.preventDefault();
		$(this).tab('show');
	});
	
	
	$('#saveBtn').click(function(){
         $.ajax({
             type: "POST",
             url: "self_account-info-save.do",
             data: {
             	id:$("#id").val(),
             	username:$("#username").val(),
             	displayName:$("#displayName").val(),
             	type:$("#type").val(),
             	cellphone:$("#cellphone").val(),
             	telephone:$("#telephone").val(),
             	email:$("#email").val(),
             	address:$("#address").val(),
             	birthday:$("#birthday").val(),
             	gender:$("#gender option:selected").val()
             },
             dataType: "json",
             success: function(d){
             	alert("修改成功");
             	history.back();
             },
             error:function(data){
			 	alert("出错了！！:"+data.msg);
			 }
         });

    });
});
    </script>
  </head>

  <body>
    <%@include file="/header/my.jsp"%>

    <div class="row-fluid">
	  <%@include file="/menu/my.jsp"%>

	  <!-- start of main -->
      <section id="m-main" class="col-md-10" style="margin-top:65px;">

      <div class="panel panel-default">
        <div class="panel-heading">
		  维护信息
		</div>

		<div class="panel-body">

<form id="pimRemindForm" method="post" action="account-info-save.do" class="form-horizontal">
  <input type="hidden" id="id" name="id" value="${accountInfo.id}"/>
  
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_userName">账号</label>
	<div class="col-sm-5">
	  <input type="text" id="username" name="username" readonly="readonly" value="${accountInfo.username}" size="40" class="form-control" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_displayName">姓名</label>
	<div class="col-sm-5">
	  <input type="text" id="displayName" name="displayName" value="${accountInfo.displayName}" size="40" class="form-control" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_type">职务</label>
	<div class="col-sm-5">
	  <input type="text" id="type" name="type" value="${accountInfo.type}" size="40" class="form-control" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_cellphone">移动电话</label>
	<div class="col-sm-5">
	  <input type="text" id="cellphone" name="cellphone" value="${accountInfo.cellphone}" size="40" class="form-control" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_telephone">固定电话</label>
	<div class="col-sm-5">
	  <input type="text" id="telephone" name="telephone" value="${accountInfo.telephone}" size="40" class="form-control" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_email">邮箱</label>
	<div class="col-sm-5">
	  <input type="text" id="email" name="email" value="${accountInfo.email}" size="40" class="form-control" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_address">地址</label>
	<div class="col-sm-5">
	  <input type="text" id="address" name="address" value="${accountInfo.address}" size="40" class="form-control" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_birthday">出生年月</label>
	<div class="input-group datepicker date">
		<input class="form-control" type="text" id="birthday" style="background-color:white;cursor:default;width: 420px;" value="${accountInfo.birthday}" name="birthday">
		<span class="input-group-addon">
	</div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="userBase_gender">性别</label>
	<div class="xf-handler">
		<select class="required" style="margin-bottom:0px;width: 420px;" required="true" id="gender" name="gender">
			<c:if test="${accountInfo.gender=='male'||accountInfo.gender==null||accountInfo.gender==''}">
				<option selected="selected" value="male">男</option>
				<option value="female">女</option>
			</c:if>
			<c:if test="${accountInfo.gender=='female'}">
				<option value="male">男</option>
				<option selected="selected" value="female">女</option>
			</c:if>
		</select>
	</div>
  </div>
  
  
  
  
  <!-- 
  <div class="form-group">
    <label class="control-label col-md-1" for="pimRemind_description">邮箱</label>
	<div class="col-sm-5">
	  <input id="pimInfo_name" type="text" name="email" value="${personInfo.email}" class="form-control required" minlength="2" maxlength="50">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-1" for="pimRemind_infoTime">电话</label>
	<div class="col-sm-5">
	  <input id="pimInfo_name" type="text" name="cellphone" value="${personInfo.cellphone}" class="form-control required" minlength="2" maxlength="50">
    </div>
  </div>
   -->
  
  <div class="form-group">
    <div class="col-md-offset-1 col-md-11">
      <button type="button" id="saveBtn" class="btn btn-default a-submit"><spring:message code='core.input.save' text='保存'/></button>
	  &nbsp;
      <button type="button" class="btn btn-default a-cancel" onclick="history.back();"><spring:message code='core.input.back' text='返回'/></button>
    </div>
  </div>
</form>
        </div>
      </div>

      </section>
	  <!-- end of main -->
	</div>

  </body>

</html>
