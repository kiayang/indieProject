<table class="table" id="makeEditable">
        <thead>
        <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email <span style="float:right"><button id="but_add">Add New Row</button></span></th>
        </tr>
        </thead>
        <tbody>
        <tr>
                <td>Default</td>
                <td>Defaultson</td>
                <td>def@somemail.com</td>
        </tr>
        <tr class="success">
                <td>Success</td>
                <td>Doe</td>
                <td>john@example.com</td>
        </tr>
        <tr class="danger">
                <td>Danger</td>
                <td>Moe</td><table class="table" id="makeEditable">
                <thead>
                <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email <span style="float:right"><button id="but_add">Add New Row</button></span></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                        <td>Default</td>
                        <td>Defaultson</td>
                        <td>def@somemail.com</td>
                </tr>
                <tr class="success">
                        <td>Success</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                </tr>
                <tr class="danger">
                        <td>Danger</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                </tr>
                <tr class="info">
                        <td>Info</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                </tr>
                <tr class="warning">
                        <td>Warning</td>
                        <td>Refs</td>
                        <td>bo@example.com</td>
                </tr>
                <tr class="active">
                        <td>Active</td>
                        <td>Activeson</td>
                        <td>act@example.com</td>
                </tr>
                </tbody>
        </table>
                <td>mary@example.com</td>
        </tr>
        <tr class="info">
                <td>Info</td>
                <td>Dooley</td>
                <td>july@example.com</td>
        </tr>
        <tr class="warning">
                <td>Warning</td>
                <td>Refs</td>
                <td>bo@example.com</td>
        </tr>
        <tr class="active">
                <td>Active</td>
                <td>Activeson</td>
                <td>act@example.com</td>
        </tr>
        </tbody>
</table>

<div class="container-fluid">
        <h2><div style="text-align: center;">Member Results Page:</div> </h2>
        <table id="memberTable" class="display" cellspacing="0" width="100%" border="1" bgcolor="#7fffd4">
                <table border="5px" class="col-lg12" style="margin:auto;width:80%;">
                        <thead>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>User Name</th>
                        </thead>
                        <body>
                        <tr>
                                <td>${user.getFirstname()}</td>
                                <td>${user.getLastname()}</td>
                                <td>${user.getUsername()}</td>
                        </tr>
                        </body>
                </table>
        </table>
</div>

<script type="text/javascript">
    let rows = 10 ;
    let language = "en" ;
    let settings = {
        responsive:true, // Make table responsive at 768px (default: true)
        emptyCell:"N/A", // Text to display in empty cells (default: "N/A")
        tr: {
            class:"some-class" // Additional row class(es)
        },
        td: {
            class:"some-other-class" // Additioanl cell class(es)
        }
    } ;

    $('#people-table').smpSortableTable(false, rows, language, settings);
</script>

<!-- ... -->

<table id="people-table">
        <thead>
        <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
        </tr>
        </thead>
        <tbody>
        <tr>
                <td>${user.getFirstname()}</td>
                <td>${user.getLastname()}</td>
                <td>${user.getUsername()}</td>
        </tr>
        </tbody>
</table>
