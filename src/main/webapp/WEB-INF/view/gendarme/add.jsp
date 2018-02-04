<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/assets/images/favicon.png"/>" />
    <title>Material Pro Admin Template - The Most Complete & Trusted Bootstrap 4 Admin Template</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/assets/plugins/bootstrap/css/bootstrap.min.css" /> " rel="stylesheet">
    <link href="<c:url value="/assets/plugins/select2/dist/css/select2.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/assets/plugins/bootstrap-select/bootstrap-select.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/assets/plugins/switchery/dist/switchery.min.css" />" rel="stylesheet" />
    <!-- Date picker plugins css -->
    <link href="<c:url value="/assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/plugins/bootstrap-datepicker/bootstrap-datepicker.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- Custom CSS -->
    <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="<c:url value="/assets/css/colors/blue.css" />" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src=<c:url value="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js" />"/>
    <script src=<c:url value="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js" />/>
    <![endif]-->
</head>
<!-- TODO HEADER-->
<jsp:include page="../header.jsp" />
<!-- ============================================================== -->
<!--Bigin WebSite ============================================================== -->



<div class="col-lg-12">
    <div class="card card-outline-info">
        <div class="card-header">
            <h4 class="m-b-0 text-white">Formullaire d'ajoute un GR</h4>
        </div>
        <div class="card-body">
            <form action="ajouter-gendarme.html" method="post">
                <div class="form-body">
                    <h3 class="card-title">Person Info</h3>
                    <hr>
                    <div class="row p-t-20">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Nom</label>
                                <input type="text" name="nom" id="firstName" class="form-control" placeholder="Nom">
                                <small class="form-control-feedback"> </small> </div>
                        </div>
                        <!--/span-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Prenom</label>
                                <input type="text"  name="prenom" id="lastName" class="form-control form-control" placeholder="Prenom">
                                <small class="form-control-feedback"> </small>
                            </div>
                        </div>
                        <!--/span-->
                    </div>

                    <div class="row p-t-20">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Mle/c</label>
                                <input type="text" name="mle" id="mle" class="form-control" placeholder="Mle/c">
                                <small class="form-control-feedback"> </small> </div>
                        </div>
                        <!--/span-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Grade</label>
                                <select name="idgrade" class="form-control select2">
                                    <c:forEach items="${grade}" var="grade">
                                        <option value=" ${grade.id}">${grade.grade}</option>
                                    </c:forEach>
                                </select>

                                <small class="form-control-feedback"> </small>
                            </div>
                        </div>
                        <!--/span-->
                    </div>

                    <!--/row-->
                    <div class="row p-t-20">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Section</label>
                                <select name="idsection" class="form-control select2 form-control">
                                    <c:forEach items="${section}" var="section">
                                        <option value="${section.id}">${section.section}</option>
                                    </c:forEach>
                                </select>
                                <small class="form-control-feedback"> </small> </div>
                        </div>
                        <!--/span-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Date Naiss</label>
                                <input type="text" name="datenaiss" class="form-control" placeholder="2018-01-01" id="mdate">
                            </div>
                        </div>
                        <!--/span-->
                    </div>
                    <!--/row-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">ID Badge</label>
                                <select name="idbadge" class="form-control select2 form-control">
                                    <c:forEach items="${badge}" var="badge">
                                        <option value="${badge.id}">${badge.id}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!--/span-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Etat De Badge</label>
                                <div class="form-check">
                                    <label class="custom-control custom-radio">
                                        <input id="radio1" name="radio" type="radio" class="custom-control-input">
                                        <span class="custom-control-indicator"></span>
                                        <span class="custom-control-description">Active</span>
                                    </label>
                                    <label class="custom-control custom-radio">
                                        <input id="radio2" name="radio" checked="" type="radio" class="custom-control-input">
                                        <span class="custom-control-indicator"></span>
                                        <span class="custom-control-description">Desactive</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <!--/span-->
                    </div>


                    <div class="row p-t-20">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">Section</label>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <select name="idservice" class="form-control select2 form-control">
                                    <c:forEach items="${service}" var="service">
                                        <option value="${service.id}">${service.service}</option>
                                    </c:forEach>
                                </select>
                                </sec:authorize>
                                <sec:authorize access="hasAnyRole('ROLE_CHEF_RH', 'ROLE_CHEF_SECTION','CHEF_SERVICE')">
                                <input type="hidden" value="<c:out value="${service.id}"/>" name="idservice" class="form-control"/>
                                <input type="text" disabled value="<c:out value="${service.service}"/>" name="service" class="form-control"/>
                                </sec:authorize>
                                <small class="form-control-feedback"> </small> </div>
                        </div>
                        <!--/span-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">CIN</label>
                                <input type="text" name="cin" class="form-control" placeholder="CIN" id="cin">
                            </div>
                        </div>
                        <!--/span-->
                    </div>


                    <!--/row-->
                    <h3 class="box-title m-t-40">Address</h3>
                    <hr>
                    <div class="row">
                        <div class="col-md-12 ">
                            <div class="form-group">
                                <label>Address</label>
                                <input type="text"  name="address" class="form-control">
                            </div>
                        </div>
                    </div>


                    <div class="form-actions">
                        <button type="submit" class="btn btn-success"> <i class="fa fa-check"></i> Ajouter</button>
                        <button type="button" class="btn btn-inverse">Cancel</button>
                    </div>
            </form>
        </div>
    </div>
</div>
















<!-- TODO Footer============================================================== -->
<jsp:include page="../footer.jsp" />
<!--End Website ============================================================== -->

<!-- ============================================================== -->
<!-- All Jquery -->
<!-- ============================================================== -->
<script src="<c:url value="/assets/plugins/jquery/jquery.min.js" />"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="<c:url value="/assets/plugins/bootstrap/js/popper.min.js" />"></script>
<script src="<c:url value="/assets/plugins/bootstrap/js/bootstrap.min.js" />"></script>
<!-- slimscrollbar scrollbar JavaScript -->
<script src="<c:url value="/assets/js/jquery.slimscroll.js" />"></script>
<!--Wave Effects -->
<script src="<c:url value="/assets/js/waves.js" />"></script>
<!--Menu sidebar -->
<script src="<c:url value="/assets/js/sidebarmenu.js" />"></script>
<!--stickey kit -->
<script src="<c:url value="/assets/plugins/sticky-kit-master/dist/sticky-kit.min.js" />"></script>
<script src="<c:url value="/assets/plugins/sparkline/jquery.sparkline.min.js" />"></script>
<!--Custom JavaScript -->
<script src="<c:url value="/assets/js/custom.min.js" />"></script>
<!-- Style select2 -->
<script src="<c:url value="/assets/plugins/select2/dist/js/select2.full.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/bootstrap-select/bootstrap-select.min.js" />" type="text/javascript"></script>
<!-- ============================================================== -->
<!-- Style switcher -->
<!-- ============================================================== -->
<script src="<c:url value="/assets/plugins/styleswitcher/jQuery.style.switcher.js" />"></script>
<script src="<c:url value="/assets/plugins/switchery/dist/switchery.min.js" />"></script>
<!-- Validation Forme -->
<script src="<c:url value="/assets/js/validation.js" />"></script>

<!-- Date Picker Plugin JavaScript -->
<script src="<c:url value="/assets/plugins/moment/moment.js" />"></script>
<script src="<c:url value="/assets/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js" />"></script>
<script src="<c:url value="/assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js" />"></script>
<script>
    $(".select2").select2();

    // switcher idbadge
    var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
    $('.js-switch').each(function() {
        new Switchery($(this)[0], $(this).data());
    });

    // MAterial Date picker
    $('#mdate').bootstrapMaterialDatePicker({ weekStart : 0, time: false });

    //validation
    ! function(window, document, $) {
        "use strict";
        $("input,select,textarea").not("[type=submit]").jqBootstrapValidation(), $(".skin-square input").iCheck({
            checkboxClass: "icheckbox_square-green",
            radioClass: "iradio_square-green"
        }), $(".touchspin").TouchSpin(), $(".switchBootstrap").bootstrapSwitch();
    }(window, document, jQuery);


</script>
</body>

</html>



