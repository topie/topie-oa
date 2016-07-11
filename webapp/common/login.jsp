<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
  <head>
    <title>登录</title>
    <%@include file="/common/meta.jsp"%>
    <title><spring:message code="core.login.title" text="登录"/></title>
	<link href="../s/my/css/layout.css" rel="stylesheet" type="text/css"/>
	<link href="../s/my/css/public.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="../s/jquery/jquery.min.js"></script>
	<script type="text/javascript">
		function focusTenant() {
			if (document.f.tenant.value == '') {
				document.f.tenant.focus();
			} else {
				focusUsername();
			}
		}
		
		function focusUsername() {
			if (document.f.j_username.value == '') {
				document.f.j_username.focus();
			} else {
				document.f.j_password.focus();
			}
		}
		//图标显示与消失
		$(function(){
			$('#del').hide();
			$('.pass2').hide();
			$('.user').focus(function(){
				$('#del').show();
				$('#del').click(function(){
					$('.user').val('');
					})
				})
			$('#lock').click(function(){
				if($('.pass').attr('name') == 1){
				$('.pass').hide();
				$('.pass2').show();
				var val = $('.pass').val();
				$('.pass2').val(val);
				$('.pass').attr('name',2);
				}else{
				$('.pass').show();
				$('.pass2').hide();
				var val2 = $('.pass2').val();
				$('.pass').val(val2);
				$('.pass').attr('name',1);
					}
			})
			$('.button').click(function(){
				window.location.href="index.html";
			})
			focusTenant();
		})
			
	</script>
  </head>
  
  <body>
	<div class="loginBg">
	    <div class="loginBox">
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	        <div class="whiteBox">
	        	<div role="alert" ${param.error==true ? '' : 'style="display:none;"'}>
			        <strong><span style="margin-left: 28px;">登陆失败：</span></strong>
					&nbsp;
			        <span style="color: red;">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</span>
			    </div>
			    <div class="form-group" style="display:none">
				    <label class="col-md-2 control-label" for="tenant">租户</label>
					<div class="col-md-10">
				      <input type='text' id="tenant" name='tenant' class="form-control" value="${empty sessionScope['SECURITY_LAST_TENANT'] ? cookie['SECURITY_LAST_TENANT'].value : sessionScope['SECURITY_LAST_TENANT']}">
				      <span id="tenantText" class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="right:15px;cursor:pointer;pointer-events:auto;display:none;"></span>
				    </div>
				</div>
			    
			    
	        
	            <form id="userForm" name="f" method="post" action="${tenantPrefix}/j_spring_security_check" class="form-horizontal">
	            <!-- 
	            <h2>用户登录</h2>
	             -->
	            <ul>
	              <li>
	              	  <span>账号：</span>
	                  <input class="user" type="text" id="username" name='j_username' value="${empty sessionScope['SECURITY_LAST_USERNAME'] ? cookie['SECURITY_LAST_USERNAME'].value : sessionScope['SECURITY_LAST_USERNAME']}"/>
	                  <i id="del"><img src="../s/my/images/icon_del.png"></i>
	              </li>
	              <li><span>密码：</span>
	                  <input class="pass" type='password' id="password" name='j_password' value=""/>
	                  <i id="lock"><img src="../s/my/images/icon_lock.png"></i>
	              </li>
	              
	              <c:if test="${sessionScope['captchaSessionToken']}">
		              <li><span>验证码：</span>
		              	<img id="captchaPicture" src="captcha.jsp?_=<%=System.currentTimeMillis()%>" onclick="this.src='captcha.jsp?_=' + new Date().getTime()">
		              	<input type='text' id="captcha" name='captcha' class="" value=''>
		              </li>
	              </c:if>
	              
	            </ul>
	            
				  <div class="form-group">
				    <label class="col-md-2 control-label" for="username">&nbsp;</label>
					<div class="col-md-10" style="margin-left: 100px;">
				      <input type='checkbox' name='_spring_security_remember_me' id="_spring_security_remember_me" />
					  <label for="_spring_security_remember_me">两周内自动登陆</label>
				    </div>
				</div>
	            
	            <p class="pt20"><input style="margin-left: 100px;" class="button" type="submit" value="登 录"></p>
	            </form>
	        </div>
	    </div>
	</div>
	
	<!--foot-->
	<div class="footer-login">Copyright© 2016 topie有限责任公司 All Right Reserved</div>
	
  </body>
</html>
