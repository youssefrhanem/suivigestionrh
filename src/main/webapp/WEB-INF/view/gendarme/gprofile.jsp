<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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


    <!-- Column -->
    <div class="col-lg-4 col-xlg-3 col-md-5">
        <div class="card">
            <div class="card-body">
                <center class="m-t-30"> <img src="../assets/images/users/5.jpg" class="img-circle" width="150" />
                    <h4 class="card-title m-t-10"><c:out value="${profile.firstname}"/> <c:out value="${profile.lastname}"/></h4>
                    <h6 class="card-subtitle">Service <c:out value="${profile.service.service}"/> Section <c:out value="${profile.section.section}"/></h6>
                </center>
            </div>
            <div>
                <hr> </div>
            <div class="card-body"> <small class="text-muted">Service </small>
                <h6><c:out value="${profile.service.service}"/></h6> <small class="text-muted p-t-30 db">Grade</small>
                <h6><c:out value="${profile.grade.grade}"/> </h6>
                <small class="text-muted p-t-30 db">Mle</small>
                <h6><c:out value="${profile.matricule}"/>/c</h6>
                <small class="text-muted">Numero de Telephone </small>
                <h6>TODO</h6>

                <small class="text-muted p-t-30 db">Address</small>
                <h6><c:out value="${profile.address}"/></h6>

            </div>
        </div>
    </div>
    <!-- Column -->
    <!-- Column -->
    <div class="col-lg-8 col-xlg-9 col-md-7">
        <div class="card">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs profile-tab" role="tablist">
                <li class="nav-item"> <a class="nav-link active" data-toggle="tab" href="#home" role="tab">Update Profile</a> </li>
            </ul>
            <!-- Tab panes -->

            <!--second tab-->

            <div class="tab-pane" id="settings" role="tabpanel">
                <div class="card-body">
                    <form class="form-horizontal form-material" novalidate action="modifier-gendarme.html" method="post">
                        <div class="form-group">
                            <label class="col-md-12">Nom</label>
                            <div class="col-md-12">
                                <input type="text"  name="nom" value="<c:out value="${profile.firstname}"/> " placeholder="Nom" class="form-control form-control-line" required data-validation-required-message="Votre Nom">
                            </div>
                        </div>

                        <div class="form-group controls">
                            <label class="col-md-12">Prenom</label>
                            <div class="col-md-12">
                                <input type="text" name="prenom" value="<c:out value="${profile.lastname}"/>" placeholder="Prenom" class="form-control form-control-line" required data-validation-required-message="Votre Prenom">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-12">Mle</label>
                            <div class="col-md-12">
                                <input type="number"  name="mle" value="<c:out value="${profile.matricule}"/>" placeholder="Mle/C" class="form-control form-control-line" required data-validation-required-message="This field is required">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-12">Select Grade</label>
                            <div class="col-sm-12">
                                <select  name="idgrade" class="form-control select2 form-control-line">
                                    <option value="<c:out value="${profile.grade.id}"/>"><c:out value="${profile.grade.grade}"/></option>
                                    <c:forEach items="${grade}" var="grade">
                                        <option value="${grade.id}">${fn:toUpperCase(grade.grade)}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
<sec:authorize access="hasRole('ROLE_ADMIN')">
                        <div class="form-group">
                            <label class="col-sm-12">Select Service</label>
                            <div class="col-sm-12">
                                <select  name="idservice" class="form-control select2 form-control-line">
                                    <option value="<c:out value="${profile.service.id}"/>"><c:out value="${profile.service.service}"/></option>
                                    <c:forEach items="${service}" var="service">
                                        <option value="${service.id}">${fn:toUpperCase(service.service)}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
</sec:authorize>
                        <div class="form-group">
                            <label class="col-sm-12">Select Section</label>
                            <div class="col-sm-12">
                                <select  name="idsection" class="form-control select2 form-control-line">
                                    <option value="<c:out value="${profile.section.id}"/>"><c:out value="${profile.section.section}"/></option>
                                    <c:forEach items="${section}" var="section">
                                        <option value="${section.id}">${fn:toUpperCase(section.section)}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="col-md-12">Date Naiss</label>
                            <div class="col-md-12">
                                <input type="text"  name="datenaiss" value="<c:out value="${profile.birthday}"/>" class="form-control" placeholder="2018-01-01" id="mdate">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-12">CIN</label>
                            <div class="col-md-12">
                                <input type="text"  name="cin" value="<c:out value="${profile.cin}"/>" placeholder="06 06 00 00 00" class="form-control form-control-line" min="10">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-12">Address</label>
                            <div class="col-md-12">
                                <textarea rows="3"  name="address" class="form-control form-control-line"><c:out value="${profile.address}"/></textarea>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-12">Select Badge id</label>
                            <div class="col-sm-12">
                                <select  name="idbadge" class="form-control select2 form-control-line">
                                    <option value="<c:out value="${profile.badge.id}"/>"><c:out value="${profile.badge.id}"/></option>
                                    <c:forEach items="${badge}" var="badge">
                                        <option value="${badge.id}">${fn:toUpperCase(badge.id)}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <input value="<c:out value="${profile.id}"/>" name="id" type="hidden">

        <%--                <div class="form-group">

                            <div class="col-md-12">
                                <label>Badge (1546) : active/desctive </label>
                                <input type="checkbox"  name="etatbadge" checked class="js-switch form-control form-control-line" data-color="#009efb" />

                            </div>
                        </div>--%>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <button class="btn btn-success">Update Profile</button>
                            </div>
                        </div>
                    </form>
                </div>
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



