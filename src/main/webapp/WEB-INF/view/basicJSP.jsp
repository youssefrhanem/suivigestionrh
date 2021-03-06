<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<jsp:include page="header.jsp" />
<!-- ============================================================== -->
<!--Bigin WebSite ============================================================== -->




















<!-- TODO Footer============================================================== -->
<jsp:include page="footer.jsp" />
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



