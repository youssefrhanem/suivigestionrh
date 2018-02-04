<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/assets/images/favicon.png"/>"/>
    <title>List Users</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/assets/plugins/bootstrap/css/bootstrap.min.css"/> " rel="stylesheet">
    <link href="<c:url value="/assets/plugins/select2/dist/css/select2.min.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/assets/plugins/bootstrap-select/bootstrap-select.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/assets/plugins/switchery/dist/switchery.min.css"/>" rel="stylesheet"/>


    <!-- Custom CSS -->
    <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="<c:url value="/assets/css/colors/blue.css"/>" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src=<c:url value="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"/>"/>
    <script src=<c:url value="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"/>/>
    <![endif]-->
</head>
<!-- TODO HEADER-->
<jsp:include page="../header.jsp"/>
<!-- ============================================================== -->
<!--Bigin WebSite ============================================================== -->


<div class="col-lg-4">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">formulaire d'ajout</h4>
            <h6 class="card-subtitle">Badge</h6>
            <form class="form p-t-20" action="ajouter-badge.html" method="post">
                <div class="form-group">
                    <label for="Numero">Numero</label>
                    <div class="input-group">
                        <div class="input-group-addon"><i class="mdi mdi-numeric-9-plus-box-multiple-outline"></i>
                        </div>
                        <input type="text" class="form-control" id="Numero" name="Numero"
                               placeholder="Numero">
                    </div>
                </div>
                <div class="form-group">
                    <label for="typebadge">Type Badge</label>
                    <div class="input-group">
                        <div class="input-group-addon"><i class="mdi mdi-format-list-bulleted-type"></i></div>
                        <select id="typebadge" name="typebadge" class="form-control select2">
                            <c:forEach items="${typeBadge}" var="typeBadge">
                                <option value="${typeBadge.id}">${typeBadge.type}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="Serie">Numero de Serie</label>
                    <div class="input-group">
                        <div class="input-group-addon"><i class="ti-align-justify"></i></div>
                        <input type="text" name="nrserie" class="form-control" id="Serie" placeholder="Numero de Serie">
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox checkbox-success">
                        <input id="checkbox1" name="etat" type="checkbox">
                        <label for="checkbox1"> Active/Désactive </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-success waves-effect waves-light m-r-10">Submit</button>

            </form>
        </div>
    </div>
</div>
<div class="col-lg-8">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Tableu de Badge</h4>
            <h6 class="card-subtitle">List</h6>

            <div class="table-responsive m-t-40">
                <table id="example23" class="display nowrap table table-hover table-striped table-bordered"
                       cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NR</th>
                        <th>Nr Serie</th>
                        <th>Type</th>
                        <th>Etat</th>
                        <th>Option</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>NR</th>
                        <th>Nr Serie</th>
                        <th>Type</th>
                        <th>Etat</th>
                        <th>Option</th>
                    </tr>
                    </tfoot>
                    <tbody>

                    <!--user-->
                    <c:forEach items="${badge}" var="badge">
                        <tr>
                            <td>${badge.id}</td>
                            <td>123</td>
                            <td>${badge.nrSerie}</td>
                            <td>${badge.typeBadge.type}</td>
                            <td>${badge.activation}</td>
                            <td>
                <span style="margin-right: 15px">
                <a href="modifier-badge.html?id=${badge.id}">
                    <i class="mdi mdi-account-edit"></i>
                </a>
                </span>
                                <span>
                  <a href="delete-badge.html?id=${badge.id}">
                      <i class="mdi mdi-account-remove"></i>
                  </a>
                </span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>


<!-- TODO Footer============================================================== -->
<jsp:include page="../footer.jsp"/>
<!--End Website ============================================================== -->

<!-- ============================================================== -->
<!-- All Jquery -->
<!-- ============================================================== -->
<script src="<c:url value="/assets/plugins/jquery/jquery.min.js"/>"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="<c:url value="/assets/plugins/bootstrap/js/popper.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
<!-- slimscrollbar scrollbar JavaScript -->
<script src="<c:url value="/assets/js/jquery.slimscroll.js"/>"></script>
<!--Wave Effects -->
<script src="<c:url value="/assets/js/waves.js"/>"></script>
<!--Menu sidebar -->
<script src="<c:url value="/assets/js/sidebarmenu.js"/>"></script>
<!--stickey kit -->
<script src="<c:url value="/assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/sparkline/jquery.sparkline.min.js"/>"></script>
<!--Custom JavaScript -->
<script src="<c:url value="/assets/js/custom.min.js"/>"></script>
<!-- Style select2 -->
<script src="<c:url value="/assets/plugins/select2/dist/js/select2.full.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/bootstrap-select/bootstrap-select.min.js"/>" type="text/javascript"></script>

<!-- This is data table -->
<script src="<c:url value="/assets/plugins/datatables/jquery.dataTables.min.js"/>"></script>
<!-- start - This is for export functionality only -->
<script src="<c:url value="https://cdn.datatables.net/buttons/1.2.2/js/dataTables.buttons.min.js"/>"></script>
<script src="<c:url value="https://cdn.datatables.net/buttons/1.2.2/js/buttons.flash.min.js"/>"></script>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"/>"></script>
<script src="<c:url value="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"/>"></script>
<script src="<c:url value="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"/>"></script>
<script src="<c:url value="https://cdn.datatables.net/buttons/1.2.2/js/buttons.html5.min.js"/>"></script>
<script src="<c:url value="https://cdn.datatables.net/buttons/1.2.2/js/buttons.print.min.js"/>"></script>

<script src="<c:url value="/assets/plugins/datatable-functionality/dataTables.buttons.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/datatable-functionality/buttons.flash.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/datatable-functionality/jszip.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/datatable-functionality/pdfmake.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/datatable-functionality/vfs_fonts.js"/>"></script>
<script src="<c:url value="/assets/plugins/datatable-functionality/buttons.html5.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/datatable-functionality/buttons.print.min.js"/>"></script>
<!-- end - This is for export functionality only -->
<script>
    $(document).ready(function () {
        $('#myTable').DataTable();
        $(document).ready(function () {
            var table = $('#example').DataTable({
                "columnDefs": [{
                    "visible": false,
                    "targets": 2
                }],
                "order": [
                    [2, 'asc']
                ],
                "displayLength": 25,
                "drawCallback": function (settings) {
                    var api = this.api();
                    var rows = api.rows({
                        page: 'current'
                    }).nodes();
                    var last = null;
                    api.column(2, {
                        page: 'current'
                    }).data().each(function (group, i) {
                        if (last !== group) {
                            $(rows).eq(i).before('<tr class="group"><td colspan="5">' + group + '</td></tr>');
                            last = group;
                        }
                    });
                }
            });
            // Order by the grouping
            $('#example tbody').on('click', 'tr.group', function () {
                var currentOrder = table.order()[0];
                if (currentOrder[0] === 2 && currentOrder[1] === 'asc') {
                    table.order([2, 'desc']).draw();
                } else {
                    table.order([2, 'asc']).draw();
                }
            });
        });
    });
    $('#example23').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    });
</script>
<!-- ============================================================== -->
<!-- Style switcher -->
<!-- ============================================================== -->
<script src="<c:url value="/assets/plugins/styleswitcher/jQuery.style.switcher.js"/>"></script>
</body>

</html>
