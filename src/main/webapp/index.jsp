<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
input{
    background-color: transparent;
}


</style>
<meta charset="utf-8">
<title>登录页面</title>
<!-- 引入easyui -->
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
<script type="text/javascript"  src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	$('#savereg').hide();//隐藏注册表
	$('#ffregupdate1').hide();//隐藏密码修改
	$('#ffregupdate2').hide();//隐藏修改新密码
	$('#ffregdel').hide();//隐藏账号注销

$("#bt2").click(function(){//点击注册账号
	$('#savereg').show();//显示注册表
	$('#ffreg').hide();//隐藏登录表
})
$("#rst2").click(function(){//点击取消注册
	$('#savereg').hide();//隐藏注册表
	$('#ffreg').show();//显示登录表
})
$("#btdel").click(function(){//点击注销账号按钮
 	$('#ffreg').hide();//隐藏登录表
	$('#ffregdel').show();//显示修改密码表
})
/* 注册账号 */
$(function(){
 	$("#btsave").click(function(){//点击注册按钮
 		$('#savereg').form('submit', {//给表单添加提交
 			url: 'save_reg.do',//调用后台路径
 			success: function(code){
 				if(code=='1'){
 					$.messager.alert('提示','提交成功,返回登录');
 					$('#savereg').hide();//隐藏注册表
 					$('#ffreg').show();//显示登录表
 				}else{
 					$.messager.alert('提示','提交失败');  
 					$.messager.alert('111111111111111111');
 				}
 			}
 		});
 	});
})
 	/* 注册账号 end*/
 	/* 账号登录*/
 	$("#bt1").click(function(){//点击登录按钮
 		$('#ffreg').form('submit', {//给登录表添加提交
 			url: 'findalll_reg.do',//调用后台路径
 			success: function(code){
 				if(code=='1'){
 					var iid=$("#iid1").val();
 				    window.location.href="Consumer.jsp?iid="+iid;//跳转到消费者页面 
 				}else  if(code=='2'){
 				    window.location.href="merchant.jsp";//跳转到商家页面
 				}else{
 					$.messager.alert('提示','登录失败,账号或者密码不正确');  
 				}
 			}
 		});
 	})
 	/* 账号登录end*/
 	/* 修改密码*/
 	$("#btupdate").click(function(){//点击修改密码按钮
 		   $('#ffreg').hide();//隐藏登录表
			$('#ffregupdate1').show();//显示修改密码表
 	})	
 	$("#bt3").click(function(){//点击提交验证密码
 		$('#ffregupdate1').form('submit', {//给验证密码表添加提交
 			url: 'findalll_reg.do',//调用后台方法
 			success: function(code){
 				if(code=='1'){
 					$('#ffregupdate1').hide();//验证成功，隐藏验证密码表
 					$('#ffregupdate2').show();//显示修改新密码表
 				}else  if(code=='2'){
 					$('#ffregupdate1').hide();//验证成功，隐藏验证密码表
 					$('#ffregupdate2').show();//显示修改新密码表
 				}else{
 					$.messager.alert('提示','账号或者密码不正确');  
 				}
 			}
 		});
 	})
 	
 	$("#bt4").click(function(){//点击修改新密码按钮
 		$('#ffregupdate2').form('submit', {//给修改新密码表添加提交
 			url: 'update_reg.do',//调用后台路径
 			success: function(code){
 				if(code=='1'){
 					$.messager.alert('提示','修改成功');  
 					$('#ffreg').show();//显示登录表
 					$('#ffregupdate2').hide();//隐藏修改新密码表
 				}else{
 					$.messager.alert('提示','修改失败,请重修改');  
 				}
 			}
 		})
 	})
 	
 	/* 修改密码end*/
 	
 	/* 注销账号*/
 	$("#bt5").click(function(){//点击注销账号按钮
 		$('#ffregdel').form('submit', {//给注销表单添加提交
 		url: 'delbyiid_reg.do',//调用后台方法
 			success: function(code){
 				if(code=='1'){
 					$.messager.alert('提示','注销成功');  
 					$('#ffreg').show();//显示注册表
 					$('#ffregdel').hide();//隐藏注销表
 				}else{
 					$.messager.alert('提示','注销失败，可能账号密码存在问题');  
 				}
 			}
 		})
 	})
 	/*注销账号end*/
})
</script>
</head>
<body>
<div align="center" style="width: 1000px;  background-image: url(img/123.jpg)">
  <form  method="post" style="padding-top: 100px" name="ffreg" id="ffreg">
  <table width="350" height="500" >
    <tr>
      <td colspan="2"><div align="center">登录</div></td>
    </tr>
    <tr>
      <td >账号：</td>
      <td ><input type="text" name="iid" id="iid1"   class="easyui-validatebox" data-options="required:true,missingMessage:'账号'"/>
      </td>
    </tr>
    <tr>
      <td >密码：</td>
      <td> <input type="password" name="passwd" id="passwd"  class="easyui-validatebox" data-options="required:true,missingMessage:'密码'"/>
      </td>
    </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="bt1" id="bt1" value="确认登录"/>
       <input type="reset" name="rst1" id="rst1" value="取消登录"/>
      </div></td>
    </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="bt2" id="bt2" value="注册账号"/>
      </div></td></tr>
      <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="btupdate" id="btupdate" value="修改密码"/>
      </div></td></tr>
      <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="btdel" id="btdel" value="注销账号"/>
      </div></td></tr>
      
  </table>
  </form>
  
  <form action=""  method="post" style="padding-top: 100px" name="savereg" id="savereg">
  <table width="350" height="500" >
    <tr>
      <td colspan="2"><div align="center">账号注册</div></td>
    </tr>
    <tr>
      <td >账号：</td>
      <td ><input type="text" name="iid" id="iid" class="easyui-validatebox" data-options="required:true,missingMessage:'自填账号'"/>
      </td>
    </tr>
    <tr>
      <td >密码：</td>
      <td> <input type="password" name="passwd" id="passwd" class="easyui-validatebox" data-options="required:true,missingMessage:'设置密码'"/>
      </td>
    </tr>
    <tr>
      <td >密保问题：</td>
      <td><select name="question" id="question" style="background-color: transparent;">
         <option   value="你的小学名称是什么？">你的小学名称是什么？</option>
         <option   value="你的中学名称是什么？">你的中学名称是什么？</option>
         <option   value="你的大学名称是什么？">你的大学名称是什么？</option>
      </select> 
      </td>
    </tr>
    <tr>
      <td >答案：</td>
      <td><input  type="text" name="answer" id="answer"  class="easyui-validatebox" data-options="required:true,missingMessage:'作为修改密码和忘记密码时的验证'"/>
      </td>
    </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="btsave" id="btsave" value="点击注册"/>
       <input type="reset" name="rst2" id="rst2" value="取消注册"/>
      </div></td>
    </tr>
  </table>
  </form>
  
  
  <form  method="post" style="padding-top: 100px" name="ffregupdate1" id="ffregupdate1">
  <table width="350" height="500" >
    <tr>
      <td colspan="2"><div align="center">密码修改</div></td>
    </tr>
    <tr>
      <td >请输入你的账号：</td>
      <td ><input type="text" name="iid" id="iid"   class="easyui-validatebox" data-options="required:true,missingMessage:'账号'"/>
      </td>
    </tr>
    <tr>
      <td >请输入你的原始密码：</td>
      <td> <input type="password" name="passwd" id="passwd"  class="easyui-validatebox" data-options="required:true,missingMessage:'密码'"/>
      </td>
    </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="bt3" id="bt3" value="提交密码"/>
       <input type="reset" name="rst1" id="rst1" value="重置"/>
      </div></td>
    </tr>    
  </table>
  </form>
    
    
    <form  method="post" style="padding-top: 100px" name="ffregupdate2" id="ffregupdate2">
  <table width="350" height="500" >
    <tr>
      <td colspan="2"><div align="center">修改新密码</div></td>
    </tr>
    <tr>
      <td >请输入你的账号：</td>
      <td ><input type="text" name="iid" id="iid"   class="easyui-validatebox" data-options="required:true,missingMessage:'账号'"/>
      </td>
    </tr>
    <tr>
      <td >请输入你的新密码：</td>
      <td> <input type="password" name="passwd" id="passwd"  class="easyui-validatebox" data-options="required:true,missingMessage:'密码'"/>
      </td>
    </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="bt4" id="bt4" value="提交密码"/>
       <input type="reset" name="rst1" id="rst1" value="重置"/>
      </div></td>
    </tr>    
  </table>
  </form>
  
  
   <form  method="post" style="padding-top: 100px" name="ffregdel" id="ffregdel">
  <table width="350" height="500" >
    <tr>
      <td colspan="2"><div align="center">账号注销</div></td>
    </tr>
    <tr>
      <td >请输入你的账号：</td>
      <td ><input type="text" name="iid" id="iid"   class="easyui-validatebox" data-options="required:true,missingMessage:'账号'"/>
      </td>
    </tr>
    <tr>
      <td >请输入你的密码：</td>
      <td> <input type="password" name="passwd" id="passwd"  class="easyui-validatebox" data-options="required:true,missingMessage:'密码'"/>
      </td>
    </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="bt5" id="bt5" value="确认注销"/>
      </div></td>
    </tr>    
  </table>
  </form>
  <br>
   <br>
    <br>
     <br>
     
      <br>
       <br>
        <br>
         <br>
          <br>
       
     
    
</div>
</body>
</html>