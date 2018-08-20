<%@ page import="com.autumn.pojo.Users" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>记账簿</title>

		<meta name="keywords" content="记账簿">
		<meta name="description" content="记账簿">

		<!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

		<link rel="shortcut icon" href="favicon.ico">
		<link href="/${appName}/commons/jslib/hplus/css/bootstrap.min.css"
			rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/font-awesome.min.css"
			rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/animate.min.css"
			rel="stylesheet">
		<link href="/${appName}/commons/jslib/hplus/css/style.min.css"
			rel="stylesheet">
		<link rel="stylesheet"
			href="/${appName}/commons/jslib/hplus/css/plugins/sweetalert/sweetalert.css"
			type="text/css"></link>
		<link href="/${appName}/commons/css/qy-style.css" rel="stylesheet">
		<style>
.page-tabs-jj a.active {
	background: #EE4000;
	color: #fff
}

.page-tabs-jj a.active i:hover,.page-tabs a.active:hover {
	background: #FF8C00;
	color: #fff
}

#accordion .panel {
	border: none;
	box-shadow: none;
	border-radius: 0;
	margin-bottom: -5px;
}

#accordion .panel-heading {
	padding: 0;
	border-radius: 0;
	border: none;
	text-align: center;
}

#accordion .panel-title a {
	display: block;
	padding: 25px 30px;
	font-size: 16px;
	font-weight: bold;
	color: #fff;
	background: #212b34;
	border-bottom: 1px solid #2F4050;
	position: relative;
	transition: all 0.5s ease 0s;
}

#accordion .panel-title a:hover {
	background: #19222a;
}

#accordion .panel-title a:after,#accordion .panel-title a.collapsed:after
	{
	content: "\f067";
	font-family: FontAwesome;
	font-size: 15px;
	font-weight: 200;
	position: absolute;
	top: 25px;
	left: 15px;
	transform: rotate(135deg);
	transition: all 0.5s ease 0s;
}

#accordion .panel-title a.collapsed:after {
	transform: rotate(0deg);
}

#accordion .panel-body {
	background: #293846;
	padding: 0 0 0 0px;
	border: none;
	position: relative;
}

#accordion .panel-body p {
	font-size: 14px;
	color: #fff;
	line-height: 25px;
	background: #3296b7;
	padding: 30px;
	margin: 0;
}

#accordion .panel-collapse .panel-body p {
	opacity: 0;
	transform: scale(0.9);
	transition: all 0.5s ease-in-out 0s;
}

#accordion .panel-collapse.in .panel-body p {
	opacity: 1;
	transform: scale(1);
}
</style>



	</head>

	<body class="fixed-sidebar full-height-layout gray-bg black-bg-gmtx"
		style="overflow: hidden">


		<div id="wrapper">
			<!--左侧导航开始-->
			<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header" style="height: 158px;">
						<div class="dropdown profile-element">
							<span><img alt="image"
									src="/${appName}/commons/images/head-index.jpg" class="img-circle" height="40%"
									width="40%" /> </span>
							<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
								class="clear"> <span class="block m-t-xs"><strong
										class="font-bold">
												昵称：${sessionScope.user.name}
											<br /></strong> </span> <span
									class="text-muted text-xs block">${sessionScope.user.sex==1?"男":"女"} ${sessionScope.user.birthday}<b
										class="caret"></b> </span> </span> </a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li>

									<a data-toggle="modal" data-keyboard="true"
										data-backdrop="true" id="btn_ResetPsw"><b>修改密码</b>
									</a>
									<!--  href="#resetPswWin" -->
								</li>
								<li>
									<a href="/${appName}/manager/loginController/loginOut"><b>安全退出</b>
									</a>
								</li>
							</ul>
						</div>
						<br/><br/>
						<div class="logo-element">

						</div>
					</li>
					

					<%--<li>
						<a href="#"> <i class="fa fa-check"></i> <span
							class="nav-label">记账簿</span><span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a class="J_menuItem"
								   href="/${appName}/jsp/cate/cateManager.jsp">消费类型</a>
							</li>
							<li>
								<a class="J_menuItem"
									href="/${appName}/jsp/book/bookManager.jsp">记账</a>
							</li>
							<li>
								<a class="J_menuItem"
									href="/${appName}/jsp/report/report.jsp">月消费分析</a>
							</li>
							<li>
								<a class="J_menuItem"
								   href="/${appName}/jsp/report/dayReport.jsp">月消费报表</a>
							</li>
							<li>
								<a class="J_menuItem"
								   href="/${appName}/jsp/report/monthReport.jsp">年消费报表</a>
							</li>
						</ul>

					</li>
					<li>
						<a href="#"> <i class="fa fa-check"></i> <span
								class="nav-label">地图</span> <span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a class="J_menuItem"
								   href="/${appName}/jsp/map/Position.jsp">实时定位</a>
							</li>
							<li>
								<a class="J_menuItem"
								   href="/${appName}/jsp/map/PositionHistory.html">历史位置</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#"> <i class="fa fa-check"></i> <span
							class="nav-label">用户权限管理</span> <span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a class="J_menuItem"
									href="/${appName}/jsp/user/userManager.jsp">用户管理</a>
							</li>
							<li>
								<a class="J_menuItem"
									href="/${appName}/jsp/role/roleManager.jsp">角色管理</a>
							</li>
						</ul>
					</li>--%>
					
				</ul>

			</div>
			</nav>
			<!--左侧导航结束-->
			<!--右侧部分开始-->
			<div id="page-wrapper" class="gray-bg dashbard-1">
				<div class="row border-bottom">
					<nav class="navbar navbar-static-top" role="navigation"
						style="margin-bottom: 0">
					<div class="navbar-header">
						<a
							class="navbar-minimalize minimalize-styl-2 btn btn-gmtx-define1"
							href="#"><i class="fa fa-bars"></i> </a>

					</div>


					</nav>
				</div>
				<div class="row content-tabs">
					<button class="roll-nav roll-left J_tabLeft">
						<i class="fa fa-backward"></i>
					</button>
					<nav class="page-tabs page-tabs-jj J_menuTabs">
					<div class="page-tabs-content">
						<a href="javascript:;" class="active J_menuTab"
							data-id="/${appName}/index_homePage.jsp">首页</a>
					</div>
					</nav>
					<button class="roll-nav roll-right J_tabRight">
						<i class="fa fa-forward"></i>
					</button>
					<div class="btn-group roll-nav roll-right">
						<button class="dropdown J_tabClose" data-toggle="dropdown">
							<b>关闭操作</b>
						</button>
						<ul role="menu" class="dropdown-menu dropdown-menu-right">
							<li class="J_tabShowActive">
								<a>定位当前选项卡</a>
							</li>
							<li class="divider">
								<br>
							</li>
							<li class="J_tabCloseAll">
								<a>关闭全部选项卡</a>
							</li>
							<li class="J_tabCloseOther">
								<a>关闭其他选项卡</a>
							</li>
						</ul>
					</div>
					<a href="/${appName}/manager/loginController/loginOut"
						class="roll-nav roll-right J_tabExit"><i
						class="fa fa fa-sign-out"></i> <b>退出</b> </a>
				</div>
				<div class="row J_mainContent" id="content-main">
					<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
						src="/${appName}/index_homePage.jsp" frameborder="0"
						data-id="/${appName}/index_homePage.jsp" seamless></iframe>
				</div>
				<div class="footer">
					<div class="pull-right">
						<font color="black">&copy; Autumn&Summer</font>
					</div>
				</div>
			</div>
			<!--右侧部分结束-->

			<!-- 修改密码窗口 -->
			<div class="modal fade" id="resetPswWin">
				<div class="modal-dialog" style="width: 400px">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true" id="clearUpPsw">
								&times;
							</button>
							<h4 class="modal-title">
								修改密码
							</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<form method="post" class="form-horizontal" id="resetform">
									<div class="form-group">
										<label class="col-sm-4 control-label">
											用户名：
										</label>
										<div class="col-sm-7 controls">
											<input type="text" value="" class="form-control"
												name="username_reset" id="username_reset" disabled
												tabindex="0" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">
											原密码：
										</label>
										<div class="col-sm-7 controls">
											<input type="password" value="" class="form-control"
												name="psw_old" id="psw_old" tabindex="1" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">
											新密码：
										</label>
										<div class="col-sm-7 controls">
											<input type="password" value="" class="form-control"
												name="psw_new" id="psw_new" tabindex="2" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">
											确认密码：
										</label>
										<div class="col-sm-7 controls">
											<input type="password" value="" class="form-control"
												name="psw_sure" id="psw_sure" tabindex="3" />
										</div>
									</div>
									<div class="form-group">
										<div class="controls">
											<button type="submit"
												class="btn btn-gmtx-define1 center-block">
												修改
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 修改密码窗口结束 -->
		</div>
	</body>

	<script src="/${appName}/commons/jslib/hplus/js/jquery.min.js"></script>
	<script
		src="/${appName}/commons/jslib/hplus/js/plugins/validate/jquery.validate.min.js"></script>
	<script
		src="/${appName}/commons/jslib/hplus/js/plugins/validate/messages_zh.min.js"></script>
	<script type="text/javascript">
			//递归菜单
			function RecMenu(m){
				var result = '';
				result +="<li>";
				if(m.children!=null&&m.children.length>0){
					result +='<a href="#"> <i class="fa fa-check"></i> <span class="nav-label">'+m.moduleName+'</span> <span class="fa arrow"></span></a>';
					result +='<ul class="nav nav-second-level">';
					for(var i=0,len=m.children.length;i<len;i++){
						result+= RecMenu(m.children[i]);
					}
					result +='</ul>';
				}else{
					result+= '<a class="J_menuItem" onclick="javascript:reloadMenu(this);" href="/${appName}/'+m.modulePath+'">'+m.moduleName+'</a>'
				}
				result +="</li>";
				return result;
			}

			//关闭修改窗口时
			$('#clearUpPsw').click(function(){
		         $("#psw_old").val('');
				 $("#psw_new").val('');
				 $("#psw_sure").val('');
			});
			/*显示修改窗口*/
			$('#btn_ResetPsw').click(function(){
				$('#username_reset').val('${sessionScope.user.usercode}');
				$("#resetPswWin").modal('show');
			});
  			$(function(){

  				/*提交修改窗口*/
				$("#resetform").validate({
						rules : {
							psw_old : {
								required : true,
								maxlength: 50
							},
							psw_new:{
								required : true,
								maxlength: 50
							},
							psw_sure:{
								required : true,
								maxlength: 50,
								equalTo:'#psw_new'
							}
						},
						messages : {
							psw_old : {
								required : "请输入原密码!",
								maxlength: "参数名过长!"
							},
							psw_new:{
								required: "请输入新密码!",
								maxlength: "参数名过长!"
							},
							psw_sure:{
								required: "请输入确认密码!",
								maxlength: "参数名过长!",
								equalTo: "确认密码与新密码不一致!"
							}
						},
						submitHandler : function() {
                            var userId="<%=((Users)session.getAttribute("user")).getId()%>";   //id
                            var userCode="<%=((Users)session.getAttribute("user")).getUsercode()%>"; //账户名
							var psw_old = $("#psw_old").val();
							var psw_new = $("#psw_new").val();
							var psw_sure = $("#psw_sure").val();
							$.ajax({
							url:'/${appName}/manager/userController/upPsw',
							type:'post',
							async:'true',
							cache:false,
							data:{userId:userId,userCode:userCode,psw_old:psw_old,psw_new:psw_new,psw_sure:psw_sure},
							dataType:'json',
							success: function(data){
									  if(data.success){
						                  swal({
				             					 title: "系统提示",
									             text: "修改成功",
									             type: "success"
									         },function(){
										         $("#psw_old").val('');
												 $("#psw_new").val('');
												 $("#psw_sure").val('');
									         	 $("#resetPswWin").modal('hide');
									         });
						              }else if(data.oldPswWrong){
						                  swal({
				             					 title: "系统提示",
									             text: "原密码错误",
									             type: "warning"
									         },function(){
										         $("#psw_old").val('');
									         });
						              }else{
						                  swal({
				             					 title: "系统提示",
									             text: "修改失败",
									             type: "warning"
									         },function(){
										         $("#psw_old").val();
												 $("#psw_new").val();
												 $("#psw_sure").val();
									         	 $("#resetPswWin").modal('hide');
									         });
						              }
						    },
				            error: function (aa, ee, rr) {
					                  swal({
				            				 title: "系统提示",
								             text: "请求服务器失败,清稍候再试",
								             type: "warning"
								         	},function(){
									         });
				            }
						});
						}
				});
				/*修改密码end*/
				var userType="<%=((Users)session.getAttribute("user")).getRoleCode()%>";
				var userId="<%=((Users)session.getAttribute("user")).getId()%>";
				if(userType!=null&&userType!=""){
					$.ajax({
						url:'/${appName}/manager/loginController/loadpermissions',
						type:'post',
						async: false,
						cache:false,
						data:{uid:userId},
						dataType:'json',
						success: function(data){
							for(var i=0,len=data.length;i<len;i++){
								var ps = data[i];
								if(ps.children.length>0){
									var result = RecMenu(ps);
									$('#side-menu').append(result);
								}else if(ps.modulePath!=null){   //如果一级是菜单,不是目录
                                    var result = RecMenu(ps);
                                    $('#side-menu').append(result);
								}
							}
						},
						error: function (aa, ee, rr) {
	  					}
					});
				}
				
				//社保人员提醒
				if(userType==1)
				{
					$('#notice_shebao').show();
  					$('#notice').hide();
  					
  					
  					$.ajax({
						url:'/${appName}/manager/LoginController/getNoticeNum_shebao',
						type:'post',
						async:'true',
						cache:false,
						data:{},
						dataType:'json',
						success: function(data){
							$("#noticeNum_shebao_2").html(data.expireNum_shebao);
							var totalNum = parseInt(data.expireNum_shebao);
							
							$("#expireNum_shebao").attr('href','/${appName}/webviews/remind/m_remindList.jsp');
							if(totalNum!=null&&totalNum!=''&&totalNum!=0){
								$("#noticeNum_shebao_1").html(totalNum);
								swal({
		            				title: "系统提示",
						            text: " <div class='alert' style='border-color: #EE4000;'> <i class='fa fa-envelope fa-fw'></i><a class='alert-link black-bg-gmtx' href='#' onclick='javascript:$(\"#expireNum_shebao\")[0].click();swal.close();'>有"+data.expireNum_shebao+"条协议即将到期,点击查看</a></div>",
						            //type: "warning",
						            html: true,
				                    confirmButtonText: "关闭",
				                    allowOutsideClick: true,
						        	confirmButtonColor: "#EE4000",
				                    closeOnConfirm: true,
				                    closeOnCancel: true,
				                    timer: '5000ms',
				                    allowEscapeKey: true
						         },function(confirm){
			      	                if(confirm){
			      	                	//'查看逾期';
			      	                }else{
			      	                	//'查看未读';
			      	                }
								});
							}
						},
	  					error: function (aa, ee, rr) {
	  					
	  					}
	  				});
				}
  			});
  			function redirectNotice(unreadOrOverdue){
  				$.ajax({
					url:'/${appName}/manager/LoginController/getTabtitle',
					type:'post',
					async:'true',
					cache:false,
					data:{},
					dataType:'json',
					success: function(data){
						$("#noticeNum2").html(data.noticeNum);
						$("#noticeNum3").html(data.expireNum);
						$("#remindNum").html(data.remindNum);
						var totalNum = parseInt(data.noticeNum)+parseInt(data.expireNum)+parseInt(data.remindNum);
						//$("#expireNum").attr('href','/${appName}/webviews/protocolList.jsp?expOpenMode=1&expDate='+data.expireDate);
						
						$("#expireNum").attr('href','/${appName}/webviews/remind/u_remindList.jsp?forwardMode=exp&expDate='+data.expireDate);
						
						//设置tabtitle
						if(unreadOrOverdue=='unread'){
							var tab='未读协议<i class="fa fa-times-circle"></i>';
							$(".J_menuTab.active").html(tab);
						}else if((unreadOrOverdue=='overdue')){
							var tab='即将到期协议<i class="fa fa-times-circle"></i>';
							$(".J_menuTab.active").html(tab);
						}else if((unreadOrOverdue=='notdeal')){
							var tab='未处理协议提醒<i class="fa fa-times-circle"></i>';
							$(".J_menuTab.active").html(tab);
						}
						//var tab=data.tabTitle+'<i class="fa fa-times-circle"></i>';
						//$(".J_menuTab.active").html(tab);
					},
  					error: function (aa, ee, rr) {
  					}
				});
  			}
  		</script>
	<script src="/${appName}/commons/jslib/hplus/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="/${appName}/commons/jslib/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script
		src="/${appName}/commons/jslib/hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="/${appName}/commons/jslib/hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="/${appName}/commons/jslib/hplus/js/plugins/layer/layer.min.js"></script>
	<script src="/${appName}/commons/jslib/hplus/js/hplus.min.js"></script>
	<script type="text/javascript"
		src="/${appName}/commons/jslib/hplus/js/contabs.min.js"></script>
	<script
		src="/${appName}/commons/jslib/hplus/js/plugins/pace/pace.min.js"></script>
	<script src="/${appName}/commons/jslib/CommonValue.js"></script>
</html>