<%@ page import="java.util.List" %>
<%@ page import="com.amazon.dto.UserDetailsDTO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Responsive Bootstrap Table</title>
    <!-- Include Bootstrap CSS from CDN -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Include Font Awesome CSS from CDN -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Add viewport meta tag for responsiveness -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Shloka Paapa My Chinnu Burger</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="welcome">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Portfolio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contact</a>
            </li>
        </ul>
    </div>
</nav>

<br>
<br>

<div class="container">
    <h2>User Details Management</h2>

    <!-- Add New User Button (outside of the table) -->
    <div class="row">
        <div class="col-12 text-right mb-3">
            <button class="btn btn-outline-success" data-toggle="modal" data-target="#addUserModal">
                Add New User
            </button>
        </div>
    </div>

    <!-- Bootstrap Table with Responsive Class -->
    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>USER ID</th>
                <th>USER NAME</th>
                <th>ADHAAR CARD NO</th>
                <th>EMAIL</th>
                <th>ACTION</th>
            </tr>
            </thead>
            <tbody>
            <%
                int currentPage = 1; // Default to the first page
                int recordsPerPage = 5; // Number of records to display per page

                String pageParam = request.getParameter("page");
                if (pageParam != null && !pageParam.isEmpty()) {
                    currentPage = Integer.parseInt(pageParam);
                }

                List<UserDetailsDTO> userdetailsData = (List<UserDetailsDTO>) request.getAttribute("userdetailsData");

                // Calculate total pages
                int totalRecords = userdetailsData.size();
                int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

                // Calculate the start and end index for the current page
                int startIndex = (currentPage - 1) * recordsPerPage;
                int endIndex = Math.min(startIndex + recordsPerPage, totalRecords);

                // Display the data for the current page
                for (int i = startIndex; i < endIndex; i++) {
                    UserDetailsDTO userDetails = userdetailsData.get(i);
            %>
            <tr>
                <td><%=userDetails.getId()%></td>
                <td><%=userDetails.getUsername()%></td>
                <td><%=userDetails.getAdharcardno()%></td>
                <td><%=userDetails.getEmail()%></td>
                <td>
                    <a href="#" data-toggle="modal" data-target="#viewModal<%=userDetails.getId()%>" title="View">
                        <i class="fas fa-eye" style="color: blue;"></i>
                    </a> &nbsp;
                    <a href="#" data-toggle="modal" data-target="#editModal<%=userDetails.getId()%>" title="Edit">
                        <i class="fas fa-edit" style="color: #C6A005;"></i>
                    </a> &nbsp;
                    <a href="openCrudTableScreen/deleteUser/<%=userDetails.getId()%>" title="Delete">
                        <i class="fas fa-trash" style="color: red;"></i>
                    </a>
                </td>
            </tr>

            <!-- View Modal for User Details -->
            <div class="modal fade" id="viewModal<%=userDetails.getId()%>" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="viewModalLabel">User Details</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <!-- Add your user details here -->
                            <p>User ID: <%=userDetails.getId()%></p>
                            <p>User Name: <%=userDetails.getUsername()%></p>
                            <p>Adhaar Card No: <%=userDetails.getAdharcardno()%></p>
                            <p>Email: <%=userDetails.getEmail()%></p>
                            <!-- You can display additional user details here -->
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Edit Modal for User Details -->
            <div class="modal fade" id="editModal<%=userDetails.getId()%>" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editModalLabel">Edit User Details</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <!-- Add form fields for editing user details here -->
                            <form action="openCrudTableScreen/updateUser" method="post" >
                                <div class="form-group" hidden style="display:none;">
                                    <label for="userid">userid</label>
                                    <input type="text" class="form-control" id="userid" name="userid" value="<%=userDetails.getId()%>">
                                </div>
                                <div class="form-group">
                                    <label for="username">Username</label>
                                    <input type="text" class="form-control" id="username" name="username" value="<%=userDetails.getUsername()%>">
                                </div>
                                <div class="form-group">
                                    <label for="adharcardno">Adhaar Card No</label>
                                    <input type="text" class="form-control" id="adharcardno" name="adharcardno" value="<%=userDetails.getAdharcardno()%>">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="text" class="form-control" id="email" name="email" value="<%=userDetails.getEmail()%>">
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%
                }
            %>
            
            
            <!-- Add New User Modal -->
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addUserModalLabel">Add New User</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Add a form for adding a new user -->
                <form action="openCrudTableScreen/addUser" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username">
                    </div>
                    <div class="form-group">
                        <label for="adharcardno">Adhaar Card No</label>
                        <input type="text" class="form-control" id="adharcardno" name="adharcardno">
                    </div>
                    <div class="form-group">
                        <label for="newEmail">Email</label>
                        <input type="text" class="form-control" id="email" name="email">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save User</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
            
            </tbody>
        </table>
    </div>
    
    
    <!-- Pagination Section -->
<div class="row">
    <div class="col-md-12">
        <ul class="pagination justify-content-center" >
            <li class="page-item">
                <a class="page-link" href="?page=1"  style="background-color: white; color: black;"  >First</a>
            </li>
            <li class="page-item">
                <a class="page-link"  href="?page=<%=currentPage - 1 %>"  style="background-color: white; color: black;" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%-- Loop through pages and display page numbers --%>
            <% for (int i = 1; i <= totalPages; i++) { %>
                <li class="page-item <%= (i == currentPage) ? "active" : "" %>">
                    <a class="page-link" href="?page=<%=i %>"   style="background-color: white; color: black;" ><%=i %></a>
                </li>
            <% } %>
            <li class="page-item">
                <a class="page-link" href="?page=<%=currentPage + 1 %>"  style="background-color: white; color: black;" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li class="page-item">
                <a class="page-link" href="?page=<%=totalPages %>"  style="background-color: white; color: black;" >Last</a>
            </li>
        </ul>
    </div>
</div>
    
    
    
</div>

<!-- Include Bootstrap JavaScript and jQuery from CDN -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
