[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="[@spring.url '/resources/images/favicon.png'/]">
    <title>${message("admin.main.title")}</title>
[#include "/admin/include/head.ftl"]
</head>
<body>

<!-- Fixed navbar -->
[#include "/admin/include/navbar.ftl"]
<div id="cl-wrapper" class="fixed-menu">
[#include "/admin/include/sidebar.ftl"]
	<div class="container-fluid" id="pcont">
		<div class="page-head">
			<h2>NEW</h2>
			<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">Inquiry</a></li>
			<li class="active">NEW</li>
			</ol>
		</div>
		<div class="cl-mcont">		
			<div class="row wizard-row">
				<div class="col-md-12 fuelux">
					<div class="block-wizard">
		        		<div class="step-content">
							<form class="form-horizontal group-border-dashed" action="save.jhtml" method="post" 
										data-parsley-namespace="data-parsley-" data-parsley-validate novalidate>
								<div class="step-pane active" id="step1">
									<table style="padding:10px;border: 0px none" width="100%">
										<tbody>
											<tr>
												<td width="13%">
													<span>
														FirstName:
													</span>
												</td>
												<td width="37%">
													<input type="text" name="firstName" class="form-control input-group1 peer" required placeholder="First Name">
												</td>
												<td width="13%">
													<span>
														LastName:
													</span>
												</td>
												<td width="37%">
													<input type="text" name="lastName" class="form-control input-group1 peer" required placeholder="Last Name">
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														Phone：
													</span>
												</td>
												<td width="37%">
													<input type="text" name="contactPhone" class="form-control input-group1 peer" placeholder="Phone">
												</td>
												<td width="13%">
													<span>
														Email：
													</span>
												</td>
												<td width="37%">
													<input type="email" name="email" class="form-control input-group1 peer" parsley-type="email" placeholder="Enter a valid e-mail">
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														Arrival Date
													</span>
												</td>
												<td width="37%">
													<div class="input-group date datetime" data-date-format="yyyy-mm-dd" data-min-view="2" style="width:60%;">
														<input name="arriveDate" class="form-control" readonly="readonly" type="text" size="16">
														<span class="input-group-addon btn btn-primary">
															<span class="glyphicon glyphicon-th"></span>
														</span>
													</div>
												</td>
												<td width="13%">
													<span>
														Hotel：
													</span>
												</td>
												<td width="37%">
													<input type="text" name="hotelStandard" class="form-control input-group1 peer" placeholder="Hotel">
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														State
													</span>
												</td>
												<td width="37%">
													<select id="selState" name="stateId" class="select2 peer" >
														<option value="">Select</option>
														[#list stateList as state]
															<option value="${state.id}">${state.stateName}</option>
														[/#list]
													</select>
												</td>
												<td width="13%">
													<span>
														Race
													</span>
												</td>
												<td width="37%">
													<select id="selhumanrace" name="humanRaceId" class="select2 peer" >
														<option value="">Select</option>
														[#list humanraceList as humanrace]
															<option value="${humanrace.humanRaceId}">${humanrace.humanRace}</option>
														[/#list]
													</select>
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														Language
													</span>
												</td>
												<td width="37%">
													<select id="sellanguage" name="languageId" class="select2 peer" >
														<option value="">Select</option>
														[#list languageList as language]
															<option value="${language.languageId}">${language.language}</option>
														[/#list]
													</select>
												</td>
												<td width="13%">
													<span>
														Nationality
													</span>
												</td>
												<td width="37%">
													<select id="selCountry" name="countryId" class="select2 peer" >
														<option value="">Select</option>
														[#list countryList as country]
															<option value="${country.id}">${country.countryName}</option>
														[/#list]
													</select>
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														Person(min-max)：
													</span>
												</td>
												<td width="37%">
													<select class=" select2 peer" name="teamPopulation">
														[#list constant.TEAM_POPULATION_STRINGS as val]
															<option value="${val}">${val}</option>
														[/#list]
													</select>
												</td>
												<td width="13%">
													<span>
														Adult：
													</span>
												</td>
												<td width="37%">
													<select class="select2 peer" name="amountOfAdult">
														<option value="">Select</option>
														[#list 1..50 as val]
															<option value="${val}">${val}</option>
														[/#list]
													</select>
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														Child：
													</span>
												</td>
												<td width="37%">
													<select class="select2 peer" name="amountBelow12">
														<option value="">Select</option>
														[#list 1..50 as val]
															<option value="${val}">${val}</option>
														[/#list]
													</select>
												</td>
												<td width="13%">
													<span>
														No Shopping(Under 21)：
													</span>
												</td>
												<td width="37%">
													<select class="select2 peer" name="amountBelow21">
														<option value="">Select</option>
														[#list 1..50 as val]
															<option value="${val}">${val}</option>
														[/#list]
													</select>
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														Shopping
													</span>
												</td>
												<td width="87%" colspan="3">
													<div class="col-sm-6">
														<label class="radio-inline"> <input type="radio" checked="" name="shoppingOption" class="icheck" value="1">Yes</label> 
														<label class="radio-inline"> <input type="radio" name="shoppingOption" class="icheck" value="2"> No</label> 
													</div>
												</td>
											</tr>
											<tr>
												<td width="13%">
													<span>
														Brand
													</span>
												</td>
												<td width="37%">
													<select id="selectBrandId" class=" select2 peer" name="brand">
														[#list constant.BRAND_ITEMS as val]
															<option value="${val}">${val}</option>
														[/#list]
													</select>
												</td>
												<td width="13%">
													Type
												</td>
												<td width="37%">
													<select id="selectTypeId" class=" select2 peer" required name="tourTypeId">
														<option value="">Select</option>
													</select>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<span>
														<br>Requirement:<br><br>
														<textarea name="specialRequirment" style="width:95%;height:200px"></textarea>
													</span>
												</td>
												<td colspan="2">
													<br>Note:<br><br>
													<textarea name="commentOfTour" style="width:95%;height:200px"></textarea>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<br>Itinerary:<br><br>
														<textarea name="privateTravelDetails" style="width:95%;height:200px"></textarea>
												</td>
												<td colspan="2">
													<br>Remark:<br><br>
														<textarea name="remarks" style="width:95%;height:200px"></textarea>
												</td>
											</tr>
										</tbody>
									</table>
									<div class="form-group" align="right">
										<div class="col-sm-12">
											<input type="hidden" id="typeId" name="type" value="0"><!--是否保存为草稿-->
											<button type="button" onclick="javascript:history.go(-1);" class="btn btn-default">Cancel</button>
											<button type="reset" onclick="resetSelect();" class="btn btn-default">Reset</button>
											<button id="formSubmit1" class="btn btn-default btn-flat"><i class="fa fa-check"></i>Save Drafts</button>
											<button id="formSubmit2" class="btn btn-primary"><i class="fa fa-check"></i>Save</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
[#include "/admin/include/foot.ftl"]
<script src="[@spring.url '/resources/js/fuelux/loader.min.js'/]" type="text/javascript"></script><!-- -->
<script src="[@spring.url '/resources/js/jquery.parsley/parsley.js'/]" type="text/javascript"></script><!-- -->
	<script type="text/javascript">
		$("#credit_slider").slider().on("slide",function(e){
		      $("#credits").html("$" + e.value);
		    });
		    $("#rate_slider").slider().on("slide",function(e){
		      $("#rate").html(e.value + "%");
		    });
		$(document).ready(function(){
			//initialize the javascript
			App.init();
			App.wizard();
			$("#selectBrandId").trigger('click');
	    	$("form select.select2").select2({
				width: '60%'
			});
			$("#formSubmit1").click(function() {
				$("#typeId").val("1");
				$("form").submit();
			});
			$("#formSubmit2").click(function() {
				$("form").submit();
			});
		});
	//bran 级联选中
	$("#selectBrandId").click(function(){
		var tourTypeList=${tourTypeList};
		var brand=$(this).val();
		var html='<option value="">Select</option>';
		$.each(tourTypeList,function(index,values){
			if(brand==values.brand){
				html+='<option value="'+values.tourTypeId+'">'+values.typeName+'</option>';
			}
		});
		$("#selectTypeId").select2("val","");
		$("#selectTypeId").empty();
		$("#selectTypeId").append(html);
	});
	</script>
</body>
</html>
