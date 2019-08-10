<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }" var="Path" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
    <meta content="Coderthemes" name="author" />
    <!-- App favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- App css -->
    <link href="${Path }/static/css/icons.min.css" rel="stylesheet" type="text/css" />
    <link href="${Path }/static/css/app.min.css" rel="stylesheet" type="text/css" />

</head>

<body>

    <!-- Begin page -->
    <div class="wrapper">

        <!-- ========== Left Sidebar Start ========== -->
       	<%@include file="/WEB-INF/jsp/leftSidebar/leftSidebar.jsp" %>
        <!-- Left Sidebar End -->

        <!-- ============================================================== -->
        <!-- Start Page Content here -->
        <!-- ============================================================== -->

        <div class="content-page">
            <div class="content">

                <!-- Topbar Start -->
                <div class="navbar-custom">
                    <ul class="list-unstyled topbar-right-menu float-right mb-0">

                        <li class="dropdown notification-list topbar-dropdown">
                            <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <img src="assets/images/flags/us.jpg" alt="user-image" class="mr-1" height="12"> <span class="align-middle">English</span> <i class="mdi mdi-chevron-down"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated topbar-dropdown-menu">

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <img src="assets/images/flags/germany.jpg" alt="user-image" class="mr-1" height="12"> <span class="align-middle">German</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <img src="assets/images/flags/italy.jpg" alt="user-image" class="mr-1" height="12"> <span class="align-middle">Italian</span>
                                </a>
                
                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <img src="assets/images/flags/spain.jpg" alt="user-image" class="mr-1" height="12"> <span class="align-middle">Spanish</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <img src="assets/images/flags/russia.jpg" alt="user-image" class="mr-1" height="12"> <span class="align-middle">Russian</span>
                                </a>

                            </div>
                        </li>

                        <li class="dropdown notification-list">
                            <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <i class="dripicons-bell noti-icon"></i>
                                <span class="noti-icon-badge"></span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated dropdown-lg">

                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h5 class="m-0">
                                        <span class="float-right">
                                            <a href="javascript: void(0);" class="text-dark">
                                                <small>Clear All</small>
                                            </a>
                                        </span>Notification
                                    </h5>
                                </div>

                                <div class="slimscroll" style="max-height: 230px;">
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-primary">
                                            <i class="mdi mdi-comment-account-outline"></i>
                                        </div>
                                        <p class="notify-details">Caleb Flakelar commented on Admin
                                            <small class="text-muted">1 min ago</small>
                                        </p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-info">
                                            <i class="mdi mdi-account-plus"></i>
                                        </div>
                                        <p class="notify-details">New user registered.
                                            <small class="text-muted">5 hours ago</small>
                                        </p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon">
                                            <img src="assets/images/users/avatar-2.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                        <p class="notify-details">Cristina Pride</p>
                                        <p class="text-muted mb-0 user-msg">
                                            <small>Hi, How are you? What about our next meeting</small>
                                        </p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-primary">
                                            <i class="mdi mdi-comment-account-outline"></i>
                                        </div>
                                        <p class="notify-details">Caleb Flakelar commented on Admin
                                            <small class="text-muted">4 days ago</small>
                                        </p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon">
                                            <img src="assets/images/users/avatar-4.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                        <p class="notify-details">Karen Robinson</p>
                                        <p class="text-muted mb-0 user-msg">
                                            <small>Wow ! this admin looks good and awesome design</small>
                                        </p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-info">
                                            <i class="mdi mdi-heart"></i>
                                        </div>
                                        <p class="notify-details">Carlos Crouch liked
                                            <b>Admin</b>
                                            <small class="text-muted">13 days ago</small>
                                        </p>
                                    </a>
                                </div>

                                <!-- All-->
                                <a href="javascript:void(0);" class="dropdown-item text-center text-primary notify-item notify-all">
                                    View All
                                </a>

                            </div>
                        </li>

                        <li class="dropdown notification-list">
                            <a class="nav-link dropdown-toggle nav-user arrow-none mr-0" data-toggle="dropdown" href="#" role="button" aria-haspopup="false"
                                aria-expanded="false">
                                <span class="account-user-avatar"> 
                                    <img src="assets/images/users/avatar-1.jpg" alt="user-image" class="rounded-circle">
                                </span>
                                <span>
                                    <span class="account-user-name">Dominic Keller</span>
                                    <span class="account-position">Founder</span>
                                </span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated topbar-dropdown-menu profile-dropdown">
                                <!-- item-->
                                <div class=" dropdown-header noti-title">
                                    <h6 class="text-overflow m-0">Welcome !</h6>
                                </div>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="mdi mdi-account-circle mr-1"></i>
                                    <span>My Account</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="mdi mdi-account-edit mr-1"></i>
                                    <span>Settings</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="mdi mdi-lifebuoy mr-1"></i>
                                    <span>Support</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="mdi mdi-lock-outline mr-1"></i>
                                    <span>Lock Screen</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="mdi mdi-logout mr-1"></i>
                                    <span>Logout</span>
                                </a>

                            </div>
                        </li>

                    </ul>
                    <button class="button-menu-mobile open-left disable-btn">
                        <i class="mdi mdi-menu"></i>
                    </button>
                    <div class="app-search">
                        <form>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="mdi mdi-magnify"></span>
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="submit">Search</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- end Topbar -->

                <!-- Start Content-->
                <div class="container-fluid">

                    <!-- start page title -->
                    <div class="row">
                        <div class="col-12">
                            <div class="page-title-box">
                                <div class="page-title-right">
                                    <ol class="breadcrumb m-0">
                                        <li class="breadcrumb-item"><a href="javascript: void(0);">Hyper</a></li>
                                        <li class="breadcrumb-item"><a href="javascript: void(0);">eCommerce</a></li>
                                        <li class="breadcrumb-item active">Checkout</li>
                                    </ol>
                                </div>
                                <h4 class="page-title">Checkout</h4>
                            </div>
                        </div>
                    </div>
                    <!-- end page title -->

                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <!-- Checkout Steps -->
                                    <ul class="nav nav-pills bg-nav-pills nav-justified mb-3">
                                        <li class="nav-item">
                                            <a href="#billing-information" data-toggle="tab" aria-expanded="false"
                                                class="nav-link rounded-0 active">
                                                <i class="mdi mdi-account-circle font-18"></i>
                                                <span class="d-none d-lg-block">Billing Info</span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="#shipping-information" data-toggle="tab" aria-expanded="true" class="nav-link rounded-0">
                                                <i class="mdi mdi-truck-fast font-18"></i>
                                                <span class="d-none d-lg-block">Shipping Info</span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="#payment-information" data-toggle="tab" aria-expanded="false" class="nav-link rounded-0">
                                                <i class="mdi mdi-cash-multiple font-18"></i>
                                                <span class="d-none d-lg-block">Payment Info</span>
                                            </a>
                                        </li>
                                    </ul>

                                    <!-- Steps Information -->
                                    <div class="tab-content">

                                        <!-- Billing Content-->
                                        <div class="tab-pane show active" id="billing-information">
                                            <div class="row">
                                                <div class="col-lg-8">
                                                    <h4 class="mt-2">Billing information</h4>

                                                    <p class="text-muted mb-4">Fill the form below in order to
                                                        send you the order's invoice.</p>

                                                    <form>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="billing-first-name">First Name</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your first name" id="billing-first-name" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="billing-last-name">Last Name</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your last name" id="billing-last-name" />
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="billing-email-address">Email Address <span class="text-danger">*</span></label>
                                                                    <input class="form-control" type="email" placeholder="Enter your email" id="billing-email-address" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="billing-phone">Phone <span class="text-danger">*</span></label>
                                                                    <input class="form-control" type="text" placeholder="(xx) xxx xxxx xxx" id="billing-phone" />
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="form-group">
                                                                    <label for="billing-address">Address</label>
                                                                    <input class="form-control" type="text" placeholder="Enter full address" id="billing-address">
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label for="billing-town-city">Town / City</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your city name" id="billing-town-city" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label for="billing-state">State</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your state" id="billing-state" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label for="billing-zip-postal">Zip / Postal Code</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your zip code" id="billing-zip-postal" />
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="form-group">
                                                                    <label>Country</label>
                                                                    <select data-toggle="select2" title="Country">
                                                                        <option value="0">Select Country</option>
                                                                        <option value="AF">Afghanistan</option>
                                                                        <option value="AL">Albania</option>
                                                                        <option value="DZ">Algeria</option>
                                                                        <option value="AS">American Samoa</option>
                                                                        <option value="AD">Andorra</option>
                                                                        <option value="AO">Angola</option>
                                                                        <option value="AI">Anguilla</option>
                                                                        <option value="AQ">Antarctica</option>
                                                                        <option value="AR">Argentina</option>
                                                                        <option value="AM">Armenia</option>
                                                                        <option value="AW">Aruba</option>
                                                                        <option value="AU">Australia</option>
                                                                        <option value="AT">Austria</option>
                                                                        <option value="AZ">Azerbaijan</option>
                                                                        <option value="BS">Bahamas</option>
                                                                        <option value="BH">Bahrain</option>
                                                                        <option value="BD">Bangladesh</option>
                                                                        <option value="BB">Barbados</option>
                                                                        <option value="BY">Belarus</option>
                                                                        <option value="BE">Belgium</option>
                                                                        <option value="BZ">Belize</option>
                                                                        <option value="BJ">Benin</option>
                                                                        <option value="BM">Bermuda</option>
                                                                        <option value="BT">Bhutan</option>
                                                                        <option value="BO">Bolivia</option>
                                                                        <option value="BW">Botswana</option>
                                                                        <option value="BV">Bouvet Island</option>
                                                                        <option value="BR">Brazil</option>
                                                                        <option value="BN">Brunei Darussalam</option>
                                                                        <option value="BG">Bulgaria</option>
                                                                        <option value="BF">Burkina Faso</option>
                                                                        <option value="BI">Burundi</option>
                                                                        <option value="KH">Cambodia</option>
                                                                        <option value="CM">Cameroon</option>
                                                                        <option value="CA">Canada</option>
                                                                        <option value="CV">Cape Verde</option>
                                                                        <option value="KY">Cayman Islands</option>
                                                                        <option value="CF">Central African Republic</option>
                                                                        <option value="TD">Chad</option>
                                                                        <option value="CL">Chile</option>
                                                                        <option value="CN">China</option>
                                                                        <option value="CX">Christmas Island</option>
                                                                        <option value="CC">Cocos (Keeling) Islands</option>
                                                                        <option value="CO">Colombia</option>
                                                                        <option value="KM">Comoros</option>
                                                                        <option value="CG">Congo</option>
                                                                        <option value="CK">Cook Islands</option>
                                                                        <option value="CR">Costa Rica</option>
                                                                        <option value="CI">Cote d'Ivoire</option>
                                                                        <option value="HR">Croatia (Hrvatska)</option>
                                                                        <option value="CU">Cuba</option>
                                                                        <option value="CY">Cyprus</option>
                                                                        <option value="CZ">Czech Republic</option>
                                                                        <option value="DK">Denmark</option>
                                                                        <option value="DJ">Djibouti</option>
                                                                        <option value="DM">Dominica</option>
                                                                        <option value="DO">Dominican Republic</option>
                                                                        <option value="EC">Ecuador</option>
                                                                        <option value="EG">Egypt</option>
                                                                        <option value="SV">El Salvador</option>
                                                                        <option value="GQ">Equatorial Guinea</option>
                                                                        <option value="ER">Eritrea</option>
                                                                        <option value="EE">Estonia</option>
                                                                        <option value="ET">Ethiopia</option>
                                                                        <option value="FK">Falkland Islands (Malvinas)</option>
                                                                        <option value="FO">Faroe Islands</option>
                                                                        <option value="FJ">Fiji</option>
                                                                        <option value="FI">Finland</option>
                                                                        <option value="FR">France</option>
                                                                        <option value="GF">French Guiana</option>
                                                                        <option value="PF">French Polynesia</option>
                                                                        <option value="GA">Gabon</option>
                                                                        <option value="GM">Gambia</option>
                                                                        <option value="GE">Georgia</option>
                                                                        <option value="DE">Germany</option>
                                                                        <option value="GH">Ghana</option>
                                                                        <option value="GI">Gibraltar</option>
                                                                        <option value="GR">Greece</option>
                                                                        <option value="GL">Greenland</option>
                                                                        <option value="GD">Grenada</option>
                                                                        <option value="GP">Guadeloupe</option>
                                                                        <option value="GU">Guam</option>
                                                                        <option value="GT">Guatemala</option>
                                                                        <option value="GN">Guinea</option>
                                                                        <option value="GW">Guinea-Bissau</option>
                                                                        <option value="GY">Guyana</option>
                                                                        <option value="HT">Haiti</option>
                                                                        <option value="HN">Honduras</option>
                                                                        <option value="HK">Hong Kong</option>
                                                                        <option value="HU">Hungary</option>
                                                                        <option value="IS">Iceland</option>
                                                                        <option value="IN">India</option>
                                                                        <option value="ID">Indonesia</option>
                                                                        <option value="IQ">Iraq</option>
                                                                        <option value="IE">Ireland</option>
                                                                        <option value="IL">Israel</option>
                                                                        <option value="IT">Italy</option>
                                                                        <option value="JM">Jamaica</option>
                                                                        <option value="JP">Japan</option>
                                                                        <option value="JO">Jordan</option>
                                                                        <option value="KZ">Kazakhstan</option>
                                                                        <option value="KE">Kenya</option>
                                                                        <option value="KI">Kiribati</option>
                                                                        <option value="KR">Korea, Republic of</option>
                                                                        <option value="KW">Kuwait</option>
                                                                        <option value="KG">Kyrgyzstan</option>
                                                                        <option value="LV">Latvia</option>
                                                                        <option value="LB">Lebanon</option>
                                                                        <option value="LS">Lesotho</option>
                                                                        <option value="LR">Liberia</option>
                                                                        <option value="LY">Libyan Arab Jamahiriya</option>
                                                                        <option value="LI">Liechtenstein</option>
                                                                        <option value="LT">Lithuania</option>
                                                                        <option value="LU">Luxembourg</option>
                                                                        <option value="MO">Macau</option>
                                                                        <option value="MG">Madagascar</option>
                                                                        <option value="MW">Malawi</option>
                                                                        <option value="MY">Malaysia</option>
                                                                        <option value="MV">Maldives</option>
                                                                        <option value="ML">Mali</option>
                                                                        <option value="MT">Malta</option>
                                                                        <option value="MH">Marshall Islands</option>
                                                                        <option value="MQ">Martinique</option>
                                                                        <option value="MR">Mauritania</option>
                                                                        <option value="MU">Mauritius</option>
                                                                        <option value="YT">Mayotte</option>
                                                                        <option value="MX">Mexico</option>
                                                                        <option value="MD">Moldova, Republic of</option>
                                                                        <option value="MC">Monaco</option>
                                                                        <option value="MN">Mongolia</option>
                                                                        <option value="MS">Montserrat</option>
                                                                        <option value="MA">Morocco</option>
                                                                        <option value="MZ">Mozambique</option>
                                                                        <option value="MM">Myanmar</option>
                                                                        <option value="NA">Namibia</option>
                                                                        <option value="NR">Nauru</option>
                                                                        <option value="NP">Nepal</option>
                                                                        <option value="NL">Netherlands</option>
                                                                        <option value="AN">Netherlands Antilles</option>
                                                                        <option value="NC">New Caledonia</option>
                                                                        <option value="NZ">New Zealand</option>
                                                                        <option value="NI">Nicaragua</option>
                                                                        <option value="NE">Niger</option>
                                                                        <option value="NG">Nigeria</option>
                                                                        <option value="NU">Niue</option>
                                                                        <option value="NF">Norfolk Island</option>
                                                                        <option value="MP">Northern Mariana Islands</option>
                                                                        <option value="NO">Norway</option>
                                                                        <option value="OM">Oman</option>
                                                                        <option value="PW">Palau</option>
                                                                        <option value="PA">Panama</option>
                                                                        <option value="PG">Papua New Guinea</option>
                                                                        <option value="PY">Paraguay</option>
                                                                        <option value="PE">Peru</option>
                                                                        <option value="PH">Philippines</option>
                                                                        <option value="PN">Pitcairn</option>
                                                                        <option value="PL">Poland</option>
                                                                        <option value="PT">Portugal</option>
                                                                        <option value="PR">Puerto Rico</option>
                                                                        <option value="QA">Qatar</option>
                                                                        <option value="RE">Reunion</option>
                                                                        <option value="RO">Romania</option>
                                                                        <option value="RU">Russian Federation</option>
                                                                        <option value="RW">Rwanda</option>
                                                                        <option value="KN">Saint Kitts and Nevis</option>
                                                                        <option value="LC">Saint LUCIA</option>
                                                                        <option value="WS">Samoa</option>
                                                                        <option value="SM">San Marino</option>
                                                                        <option value="ST">Sao Tome and Principe</option>
                                                                        <option value="SA">Saudi Arabia</option>
                                                                        <option value="SN">Senegal</option>
                                                                        <option value="SC">Seychelles</option>
                                                                        <option value="SL">Sierra Leone</option>
                                                                        <option value="SG">Singapore</option>
                                                                        <option value="SK">Slovakia (Slovak Republic)</option>
                                                                        <option value="SI">Slovenia</option>
                                                                        <option value="SB">Solomon Islands</option>
                                                                        <option value="SO">Somalia</option>
                                                                        <option value="ZA">South Africa</option>
                                                                        <option value="ES">Spain</option>
                                                                        <option value="LK">Sri Lanka</option>
                                                                        <option value="SH">St. Helena</option>
                                                                        <option value="PM">St. Pierre and Miquelon</option>
                                                                        <option value="SD">Sudan</option>
                                                                        <option value="SR">Suriname</option>
                                                                        <option value="SZ">Swaziland</option>
                                                                        <option value="SE">Sweden</option>
                                                                        <option value="CH">Switzerland</option>
                                                                        <option value="SY">Syrian Arab Republic</option>
                                                                        <option value="TW">Taiwan, Province of China</option>
                                                                        <option value="TJ">Tajikistan</option>
                                                                        <option value="TZ">Tanzania, United Republic of</option>
                                                                        <option value="TH">Thailand</option>
                                                                        <option value="TG">Togo</option>
                                                                        <option value="TK">Tokelau</option>
                                                                        <option value="TO">Tonga</option>
                                                                        <option value="TT">Trinidad and Tobago</option>
                                                                        <option value="TN">Tunisia</option>
                                                                        <option value="TR">Turkey</option>
                                                                        <option value="TM">Turkmenistan</option>
                                                                        <option value="TC">Turks and Caicos Islands</option>
                                                                        <option value="TV">Tuvalu</option>
                                                                        <option value="UG">Uganda</option>
                                                                        <option value="UA">Ukraine</option>
                                                                        <option value="AE">United Arab Emirates</option>
                                                                        <option value="GB">United Kingdom</option>
                                                                        <option value="US">United States</option>
                                                                        <option value="UY">Uruguay</option>
                                                                        <option value="UZ">Uzbekistan</option>
                                                                        <option value="VU">Vanuatu</option>
                                                                        <option value="VE">Venezuela</option>
                                                                        <option value="VN">Viet Nam</option>
                                                                        <option value="VG">Virgin Islands (British)</option>
                                                                        <option value="VI">Virgin Islands (U.S.)</option>
                                                                        <option value="WF">Wallis and Futuna Islands</option>
                                                                        <option value="EH">Western Sahara</option>
                                                                        <option value="YE">Yemen</option>
                                                                        <option value="ZM">Zambia</option>
                                                                        <option value="ZW">Zimbabwe</option>                                    
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="form-group">
                                                                    <div class="custom-control custom-checkbox">
                                                                        <input type="checkbox" class="custom-control-input" id="customCheck2">
                                                                        <label class="custom-control-label" for="customCheck2">Ship to different address ?</label>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group mt-3">
                                                                    <label for="example-textarea">Order Notes:</label>
                                                                    <textarea class="form-control" id="example-textarea" rows="3" placeholder="Write some note.."></textarea>
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->

                                                        <div class="row mt-4">
                                                            <div class="col-sm-6">
                                                                <a href="apps-ecommerce-shopping-cart.html" class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
                                                                    <i class="mdi mdi-arrow-left"></i> Back to Shopping Cart </a>
                                                            </div> <!-- end col -->
                                                            <div class="col-sm-6">
                                                                <div class="text-sm-right">
                                                                    <a href="apps-ecommerce-checkout.html" class="btn btn-danger">
                                                                        <i class="mdi mdi-truck-fast mr-1"></i> Proceed to Shipping </a>
                                                                </div>
                                                            </div> <!-- end col -->
                                                        </div> <!-- end row -->
                                                    </form>
                                                </div>
                                                <div class="col-lg-4">
                                                    <div class="border p-3 mt-4 mt-lg-0 rounded">
                                                        <h4 class="header-title mb-3">Order Summary</h4>
        
                                                        <div class="table-responsive">
                                                            <table class="table table-centered mb-0">
                                                                <tbody>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-1.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Amazing Modern Chair</a>
                                                                                <br>
                                                                                <small>5 x $148.66</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $743.30
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-2.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Designer Awesome Chair</a>
                                                                                <br>
                                                                                <small>2 x $99.00</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $198.00
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-3.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Biblio Plastic Armchair</a>
                                                                                <br>
                                                                                <small>1 x $129.99</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $129.99
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h6 class="m-0">Sub Total:</h6>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $1071.29
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h6 class="m-0">Shipping:</h6>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            FREE
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h5 class="m-0">Total:</h5>
                                                                        </td>
                                                                        <td class="text-right font-weight-semibold">
                                                                            $1071.29
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <!-- end table-responsive -->
                                                    </div> <!-- end .border-->
        
                                                </div> <!-- end col -->            
                                            </div> <!-- end row-->
                                        </div>
                                        <!-- End Billing Information Content-->

                                        <!-- Shipping Content-->
                                        <div class="tab-pane" id="shipping-information">
                                            <div class="row">
                                                <div class="col-lg-8">
                                                    <h4 class="mt-2">Saved Address</h4>

                                                    <p class="text-muted mb-3">Fill the form below in order to
                                                        send you the order's invoice.</p>

                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="border p-3 rounded">
                                                                <address class="mb-0 font-14 address-lg">
                                                                    <div class="custom-control custom-radio">
                                                                        <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input" checked>
                                                                        <label class="custom-control-label font-16 font-weight-bold" for="customRadio1">Home</label>
                                                                    </div>
                                                                    <br/>
                                                                    <span class="font-weight-semibold">Stanley Jones</span> <br/>
                                                                    795 Folsom Ave, Suite 600<br>
                                                                    San Francisco, CA 94107<br>
                                                                    <abbr title="Phone">P:</abbr> (123) 456-7890 <br>
                                                                </address>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="border p-3 rounded">
                                                                <address class="mb-0 font-14 address-lg">
                                                                    <div class="custom-control custom-radio">
                                                                        <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input">
                                                                        <label class="custom-control-label font-16 font-weight-bold" for="customRadio2">Office</label>
                                                                    </div>
                                                                    <br/>
                                                                    <span class="font-weight-semibold">Stanley Jones</span> <br/>
                                                                    795 Folsom Ave, Suite 600<br>
                                                                    San Francisco, CA 94107<br>
                                                                    <abbr title="Phone">P:</abbr> (123) 456-7890 <br>
                                                                </address>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- end row-->

                                                    <h4 class="mt-4">Add New Address</h4>

                                                    <p class="text-muted mb-4">Fill the form below so we can
                                                        send you the order's invoice.</p>

                                                    <form>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="new-adr-first-name">First Name</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your first name" id="new-adr-first-name" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="new-adr-last-name">Last Name</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your last name" id="new-adr-last-name" />
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="new-adr-email-address">Email Address <span class="text-danger">*</span></label>
                                                                    <input class="form-control" type="email" placeholder="Enter your email" id="new-adr-email-address" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="new-adr-phone">Phone <span class="text-danger">*</span></label>
                                                                    <input class="form-control" type="text" placeholder="(xx) xxx xxxx xxx" id="new-adr-phone" />
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="form-group">
                                                                    <label for="new-adr-address">Address</label>
                                                                    <input class="form-control" type="text" placeholder="Enter full address" id="new-adr-address">
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label for="new-adr-town-city">Town / City</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your city name" id="new-adr-town-city" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label for="new-adr-state">State</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your state" id="new-adr-state" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label for="new-adr-zip-postal">Zip / Postal Code</label>
                                                                    <input class="form-control" type="text" placeholder="Enter your zip code" id="new-adr-zip-postal" />
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="form-group">
                                                                    <label>Country</label>
                                                                    <select data-toggle="select2" title="Country">
                                                                        <option value="0">Select Country</option>
                                                                        <option value="AF">Afghanistan</option>
                                                                        <option value="AL">Albania</option>
                                                                        <option value="DZ">Algeria</option>
                                                                        <option value="AS">American Samoa</option>
                                                                        <option value="AD">Andorra</option>
                                                                        <option value="AO">Angola</option>
                                                                        <option value="AI">Anguilla</option>
                                                                        <option value="AQ">Antarctica</option>
                                                                        <option value="AR">Argentina</option>
                                                                        <option value="AM">Armenia</option>
                                                                        <option value="AW">Aruba</option>
                                                                        <option value="AU">Australia</option>
                                                                        <option value="AT">Austria</option>
                                                                        <option value="AZ">Azerbaijan</option>
                                                                        <option value="BS">Bahamas</option>
                                                                        <option value="BH">Bahrain</option>
                                                                        <option value="BD">Bangladesh</option>
                                                                        <option value="BB">Barbados</option>
                                                                        <option value="BY">Belarus</option>
                                                                        <option value="BE">Belgium</option>
                                                                        <option value="BZ">Belize</option>
                                                                        <option value="BJ">Benin</option>
                                                                        <option value="BM">Bermuda</option>
                                                                        <option value="BT">Bhutan</option>
                                                                        <option value="BO">Bolivia</option>
                                                                        <option value="BW">Botswana</option>
                                                                        <option value="BV">Bouvet Island</option>
                                                                        <option value="BR">Brazil</option>
                                                                        <option value="BN">Brunei Darussalam</option>
                                                                        <option value="BG">Bulgaria</option>
                                                                        <option value="BF">Burkina Faso</option>
                                                                        <option value="BI">Burundi</option>
                                                                        <option value="KH">Cambodia</option>
                                                                        <option value="CM">Cameroon</option>
                                                                        <option value="CA">Canada</option>
                                                                        <option value="CV">Cape Verde</option>
                                                                        <option value="KY">Cayman Islands</option>
                                                                        <option value="CF">Central African Republic</option>
                                                                        <option value="TD">Chad</option>
                                                                        <option value="CL">Chile</option>
                                                                        <option value="CN">China</option>
                                                                        <option value="CX">Christmas Island</option>
                                                                        <option value="CC">Cocos (Keeling) Islands</option>
                                                                        <option value="CO">Colombia</option>
                                                                        <option value="KM">Comoros</option>
                                                                        <option value="CG">Congo</option>
                                                                        <option value="CK">Cook Islands</option>
                                                                        <option value="CR">Costa Rica</option>
                                                                        <option value="CI">Cote d'Ivoire</option>
                                                                        <option value="HR">Croatia (Hrvatska)</option>
                                                                        <option value="CU">Cuba</option>
                                                                        <option value="CY">Cyprus</option>
                                                                        <option value="CZ">Czech Republic</option>
                                                                        <option value="DK">Denmark</option>
                                                                        <option value="DJ">Djibouti</option>
                                                                        <option value="DM">Dominica</option>
                                                                        <option value="DO">Dominican Republic</option>
                                                                        <option value="EC">Ecuador</option>
                                                                        <option value="EG">Egypt</option>
                                                                        <option value="SV">El Salvador</option>
                                                                        <option value="GQ">Equatorial Guinea</option>
                                                                        <option value="ER">Eritrea</option>
                                                                        <option value="EE">Estonia</option>
                                                                        <option value="ET">Ethiopia</option>
                                                                        <option value="FK">Falkland Islands (Malvinas)</option>
                                                                        <option value="FO">Faroe Islands</option>
                                                                        <option value="FJ">Fiji</option>
                                                                        <option value="FI">Finland</option>
                                                                        <option value="FR">France</option>
                                                                        <option value="GF">French Guiana</option>
                                                                        <option value="PF">French Polynesia</option>
                                                                        <option value="GA">Gabon</option>
                                                                        <option value="GM">Gambia</option>
                                                                        <option value="GE">Georgia</option>
                                                                        <option value="DE">Germany</option>
                                                                        <option value="GH">Ghana</option>
                                                                        <option value="GI">Gibraltar</option>
                                                                        <option value="GR">Greece</option>
                                                                        <option value="GL">Greenland</option>
                                                                        <option value="GD">Grenada</option>
                                                                        <option value="GP">Guadeloupe</option>
                                                                        <option value="GU">Guam</option>
                                                                        <option value="GT">Guatemala</option>
                                                                        <option value="GN">Guinea</option>
                                                                        <option value="GW">Guinea-Bissau</option>
                                                                        <option value="GY">Guyana</option>
                                                                        <option value="HT">Haiti</option>
                                                                        <option value="HN">Honduras</option>
                                                                        <option value="HK">Hong Kong</option>
                                                                        <option value="HU">Hungary</option>
                                                                        <option value="IS">Iceland</option>
                                                                        <option value="IN">India</option>
                                                                        <option value="ID">Indonesia</option>
                                                                        <option value="IQ">Iraq</option>
                                                                        <option value="IE">Ireland</option>
                                                                        <option value="IL">Israel</option>
                                                                        <option value="IT">Italy</option>
                                                                        <option value="JM">Jamaica</option>
                                                                        <option value="JP">Japan</option>
                                                                        <option value="JO">Jordan</option>
                                                                        <option value="KZ">Kazakhstan</option>
                                                                        <option value="KE">Kenya</option>
                                                                        <option value="KI">Kiribati</option>
                                                                        <option value="KR">Korea, Republic of</option>
                                                                        <option value="KW">Kuwait</option>
                                                                        <option value="KG">Kyrgyzstan</option>
                                                                        <option value="LV">Latvia</option>
                                                                        <option value="LB">Lebanon</option>
                                                                        <option value="LS">Lesotho</option>
                                                                        <option value="LR">Liberia</option>
                                                                        <option value="LY">Libyan Arab Jamahiriya</option>
                                                                        <option value="LI">Liechtenstein</option>
                                                                        <option value="LT">Lithuania</option>
                                                                        <option value="LU">Luxembourg</option>
                                                                        <option value="MO">Macau</option>
                                                                        <option value="MG">Madagascar</option>
                                                                        <option value="MW">Malawi</option>
                                                                        <option value="MY">Malaysia</option>
                                                                        <option value="MV">Maldives</option>
                                                                        <option value="ML">Mali</option>
                                                                        <option value="MT">Malta</option>
                                                                        <option value="MH">Marshall Islands</option>
                                                                        <option value="MQ">Martinique</option>
                                                                        <option value="MR">Mauritania</option>
                                                                        <option value="MU">Mauritius</option>
                                                                        <option value="YT">Mayotte</option>
                                                                        <option value="MX">Mexico</option>
                                                                        <option value="MD">Moldova, Republic of</option>
                                                                        <option value="MC">Monaco</option>
                                                                        <option value="MN">Mongolia</option>
                                                                        <option value="MS">Montserrat</option>
                                                                        <option value="MA">Morocco</option>
                                                                        <option value="MZ">Mozambique</option>
                                                                        <option value="MM">Myanmar</option>
                                                                        <option value="NA">Namibia</option>
                                                                        <option value="NR">Nauru</option>
                                                                        <option value="NP">Nepal</option>
                                                                        <option value="NL">Netherlands</option>
                                                                        <option value="AN">Netherlands Antilles</option>
                                                                        <option value="NC">New Caledonia</option>
                                                                        <option value="NZ">New Zealand</option>
                                                                        <option value="NI">Nicaragua</option>
                                                                        <option value="NE">Niger</option>
                                                                        <option value="NG">Nigeria</option>
                                                                        <option value="NU">Niue</option>
                                                                        <option value="NF">Norfolk Island</option>
                                                                        <option value="MP">Northern Mariana Islands</option>
                                                                        <option value="NO">Norway</option>
                                                                        <option value="OM">Oman</option>
                                                                        <option value="PW">Palau</option>
                                                                        <option value="PA">Panama</option>
                                                                        <option value="PG">Papua New Guinea</option>
                                                                        <option value="PY">Paraguay</option>
                                                                        <option value="PE">Peru</option>
                                                                        <option value="PH">Philippines</option>
                                                                        <option value="PN">Pitcairn</option>
                                                                        <option value="PL">Poland</option>
                                                                        <option value="PT">Portugal</option>
                                                                        <option value="PR">Puerto Rico</option>
                                                                        <option value="QA">Qatar</option>
                                                                        <option value="RE">Reunion</option>
                                                                        <option value="RO">Romania</option>
                                                                        <option value="RU">Russian Federation</option>
                                                                        <option value="RW">Rwanda</option>
                                                                        <option value="KN">Saint Kitts and Nevis</option>
                                                                        <option value="LC">Saint LUCIA</option>
                                                                        <option value="WS">Samoa</option>
                                                                        <option value="SM">San Marino</option>
                                                                        <option value="ST">Sao Tome and Principe</option>
                                                                        <option value="SA">Saudi Arabia</option>
                                                                        <option value="SN">Senegal</option>
                                                                        <option value="SC">Seychelles</option>
                                                                        <option value="SL">Sierra Leone</option>
                                                                        <option value="SG">Singapore</option>
                                                                        <option value="SK">Slovakia (Slovak Republic)</option>
                                                                        <option value="SI">Slovenia</option>
                                                                        <option value="SB">Solomon Islands</option>
                                                                        <option value="SO">Somalia</option>
                                                                        <option value="ZA">South Africa</option>
                                                                        <option value="ES">Spain</option>
                                                                        <option value="LK">Sri Lanka</option>
                                                                        <option value="SH">St. Helena</option>
                                                                        <option value="PM">St. Pierre and Miquelon</option>
                                                                        <option value="SD">Sudan</option>
                                                                        <option value="SR">Suriname</option>
                                                                        <option value="SZ">Swaziland</option>
                                                                        <option value="SE">Sweden</option>
                                                                        <option value="CH">Switzerland</option>
                                                                        <option value="SY">Syrian Arab Republic</option>
                                                                        <option value="TW">Taiwan, Province of China</option>
                                                                        <option value="TJ">Tajikistan</option>
                                                                        <option value="TZ">Tanzania, United Republic of</option>
                                                                        <option value="TH">Thailand</option>
                                                                        <option value="TG">Togo</option>
                                                                        <option value="TK">Tokelau</option>
                                                                        <option value="TO">Tonga</option>
                                                                        <option value="TT">Trinidad and Tobago</option>
                                                                        <option value="TN">Tunisia</option>
                                                                        <option value="TR">Turkey</option>
                                                                        <option value="TM">Turkmenistan</option>
                                                                        <option value="TC">Turks and Caicos Islands</option>
                                                                        <option value="TV">Tuvalu</option>
                                                                        <option value="UG">Uganda</option>
                                                                        <option value="UA">Ukraine</option>
                                                                        <option value="AE">United Arab Emirates</option>
                                                                        <option value="GB">United Kingdom</option>
                                                                        <option value="US">United States</option>
                                                                        <option value="UY">Uruguay</option>
                                                                        <option value="UZ">Uzbekistan</option>
                                                                        <option value="VU">Vanuatu</option>
                                                                        <option value="VE">Venezuela</option>
                                                                        <option value="VN">Viet Nam</option>
                                                                        <option value="VG">Virgin Islands (British)</option>
                                                                        <option value="VI">Virgin Islands (U.S.)</option>
                                                                        <option value="WF">Wallis and Futuna Islands</option>
                                                                        <option value="EH">Western Sahara</option>
                                                                        <option value="YE">Yemen</option>
                                                                        <option value="ZM">Zambia</option>
                                                                        <option value="ZW">Zimbabwe</option>                                    
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->

                                                        <h4 class="mt-4">Shipping Method</h4>

                                                        <p class="text-muted mb-3">Fill the form below in order to
                                                            send you the order's invoice.</p>

                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="border p-3 rounded">
                                                                    <div class="custom-control custom-radio">
                                                                        <input type="radio" id="shippingMethodRadio1" name="shippingOptions" class="custom-control-input" checked>
                                                                        <label class="custom-control-label font-16 font-weight-bold" for="shippingMethodRadio1">Standard Delivery - FREE</label>
                                                                    </div>
                                                                    <p class="mb-0 pl-3 pt-1">Estimated 5-7 days shipping (Duties and tax may be due upon delivery)</p>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="border p-3 rounded">
                                                                    <div class="custom-control custom-radio">
                                                                        <input type="radio" id="shippingMethodRadio2" name="shippingOptions" class="custom-control-input">
                                                                        <label class="custom-control-label font-16 font-weight-bold" for="shippingMethodRadio2">Fast Delivery - $25</label>
                                                                    </div>
                                                                    <p class="mb-0 pl-3 pt-1">Estimated 1-2 days shipping (Duties and tax may be due upon delivery)</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- end row-->

                                                        <div class="row mt-4">
                                                            <div class="col-sm-6">
                                                                <a href="apps-ecommerce-shopping-cart.html" class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
                                                                    <i class="mdi mdi-arrow-left"></i> Back to Shopping Cart </a>
                                                            </div> <!-- end col -->
                                                            <div class="col-sm-6">
                                                                <div class="text-sm-right">
                                                                    <a href="apps-ecommerce-checkout.html" class="btn btn-danger">
                                                                        <i class="mdi mdi-cash-multiple mr-1"></i> Continue to Payment </a>
                                                                </div>
                                                            </div> <!-- end col -->
                                                        </div> <!-- end row -->
                                                    </form>
                                                </div>
                                                <div class="col-lg-4">
                                                    <div class="border p-3 mt-4 mt-lg-0 rounded">
                                                        <h4 class="header-title mb-3">Order Summary</h4>
        
                                                        <div class="table-responsive">
                                                            <table class="table table-centered mb-0">
                                                                <tbody>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-1.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Amazing Modern Chair</a>
                                                                                <br>
                                                                                <small>5 x $148.66</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $743.30
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-2.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Designer Awesome Chair</a>
                                                                                <br>
                                                                                <small>2 x $99.00</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $198.00
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-3.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Biblio Plastic Armchair</a>
                                                                                <br>
                                                                                <small>1 x $129.99</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $129.99
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h6 class="m-0">Sub Total:</h6>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $1071.29
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h6 class="m-0">Shipping:</h6>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            FREE
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h5 class="m-0">Total:</h5>
                                                                        </td>
                                                                        <td class="text-right font-weight-semibold">
                                                                            $1071.29
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <!-- end table-responsive -->
                                                    </div> <!-- end .border-->
        
                                                </div> <!-- end col -->            
                                            </div> <!-- end row-->
                                        </div>
                                        <!-- End Shipping Information Content-->

                                        <!-- Payment Content-->
                                        <div class="tab-pane" id="payment-information">
                                            <div class="row">

                                                <div class="col-lg-8">
                                                    <h4 class="mt-2">Payment Selection</h4>

                                                    <p class="text-muted mb-4">Fill the form below in order to
                                                        send you the order's invoice.</p>

                                                    <!-- Pay with Paypal box-->
                                                    <div class="border p-3 mb-3 rounded">
                                                        <div class="row">
                                                            <div class="col-sm-8">
                                                                <div class="custom-control custom-radio">
                                                                    <input type="radio" id="BillingOptRadio2" name="billingOptions" class="custom-control-input">
                                                                    <label class="custom-control-label font-16 font-weight-bold" for="BillingOptRadio2">Pay with Paypal</label>
                                                                </div>
                                                                <p class="mb-0 pl-3 pt-1">You will be redirected to PayPal website to complete your purchase securely.</p>
                                                            </div>
                                                            <div class="col-sm-4 text-sm-right mt-3 mt-sm-0">
                                                                <img src="assets/images/payments/paypal.png" height="25" alt="paypal-img">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- end Pay with Paypal box-->

                                                    <!-- Credit/Debit Card box-->
                                                    <div class="border p-3 mb-3 rounded">
                                                        <div class="row">
                                                            <div class="col-sm-8">
                                                                <div class="custom-control custom-radio">
                                                                    <input type="radio" id="BillingOptRadio1" name="billingOptions" class="custom-control-input" checked>
                                                                    <label class="custom-control-label font-16 font-weight-bold" for="BillingOptRadio1">Credit / Debit Card</label>
                                                                </div>
                                                                <p class="mb-0 pl-3 pt-1">Safe money transfer using your bank account. We support Mastercard, Visa, Discover and Stripe.</p>
                                                            </div>
                                                            <div class="col-sm-4 text-sm-right mt-3 mt-sm-0">
                                                                <img src="assets/images/payments/master.png" height="24" alt="master-card-img">
                                                                <img src="assets/images/payments/discover.png" height="24" alt="discover-card-img">
                                                                <img src="assets/images/payments/visa.png" height="24" alt="visa-card-img">
                                                                <img src="assets/images/payments/stripe.png" height="24" alt="stripe-card-img">
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row mt-4">
                                                            <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <label for="card-number">Card Number</label>
                                                                    <input type="text" id="card-number" class="form-control" data-toggle="input-mask" data-mask-format="0000 0000 0000 0000" placeholder="4242 4242 4242 4242">
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="card-name-on">Name on card</label>
                                                                    <input type="text" id="card-name-on" class="form-control" placeholder="Master Shreyu">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label for="card-expiry-date">Expiry date</label>
                                                                    <input type="text" id="card-expiry-date" class="form-control" data-toggle="input-mask" data-mask-format="00/00" placeholder="MM/YY">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label for="card-cvv">CVV code</label>
                                                                    <input type="text" id="card-cvv" class="form-control" data-toggle="input-mask" data-mask-format="000" placeholder="012">
                                                                </div>
                                                            </div>
                                                        </div> <!-- end row -->
                                                    </div>
                                                    <!-- end Credit/Debit Card box-->

                                                    <!-- Pay with Payoneer box-->
                                                    <div class="border p-3 mb-3 rounded">
                                                        <div class="row">
                                                            <div class="col-sm-8">
                                                                <div class="custom-control custom-radio">
                                                                    <input type="radio" id="BillingOptRadio3" name="billingOptions" class="custom-control-input">
                                                                    <label class="custom-control-label font-16 font-weight-bold" for="BillingOptRadio3">Pay with Payoneer</label>
                                                                </div>
                                                                <p class="mb-0 pl-3 pt-1">You will be redirected to Payoneer website to complete your purchase securely.</p>
                                                            </div>
                                                            <div class="col-sm-4 text-sm-right mt-3 mt-sm-0">
                                                                <img src="assets/images/payments/payoneer.png" height="30" alt="paypal-img">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- end Pay with Payoneer box-->

                                                    <!-- Cash on Delivery box-->
                                                    <div class="border p-3 mb-3 rounded">
                                                        <div class="row">
                                                            <div class="col-sm-8">
                                                                <div class="custom-control custom-radio">
                                                                    <input type="radio" id="BillingOptRadio4" name="billingOptions" class="custom-control-input">
                                                                    <label class="custom-control-label font-16 font-weight-bold" for="BillingOptRadio4">Cash on Delivery</label>
                                                                </div>
                                                                <p class="mb-0 pl-3 pt-1">Pay with cash when your order is delivered.</p>
                                                            </div>
                                                            <div class="col-sm-4 text-sm-right mt-3 mt-sm-0">
                                                                <img src="assets/images/payments/cod.png" height="22" alt="paypal-img">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- end Cash on Delivery box-->

                                                    <div class="row mt-4">
                                                        <div class="col-sm-6">
                                                            <a href="apps-ecommerce-shopping-cart.html" class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
                                                                <i class="mdi mdi-arrow-left"></i> Back to Shopping Cart </a>
                                                        </div> <!-- end col -->
                                                        <div class="col-sm-6">
                                                            <div class="text-sm-right">
                                                                <a href="apps-ecommerce-checkout.html" class="btn btn-danger">
                                                                    <i class="mdi mdi-cash-multiple mr-1"></i> Complete Order </a>
                                                            </div>
                                                        </div> <!-- end col -->
                                                    </div> <!-- end row-->

                                                </div> <!-- end col -->

                                                <div class="col-lg-4">
                                                    <div class="border p-3 mt-4 mt-lg-0 rounded">
                                                        <h4 class="header-title mb-3">Order Summary</h4>
        
                                                        <div class="table-responsive">
                                                            <table class="table table-centered mb-0">
                                                                <tbody>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-1.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Amazing Modern Chair</a>
                                                                                <br>
                                                                                <small>5 x $148.66</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $743.30
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-2.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Designer Awesome Chair</a>
                                                                                <br>
                                                                                <small>2 x $99.00</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $198.00
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <img src="assets/images/products/product-3.jpg" alt="contact-img"
                                                                                title="contact-img" class="rounded mr-2" height="48" />
                                                                            <p class="m-0 d-inline-block align-middle">
                                                                                <a href="apps-ecommerce-products-details.html"
                                                                                    class="text-body font-weight-semibold">Biblio Plastic Armchair</a>
                                                                                <br>
                                                                                <small>1 x $129.99</small>
                                                                            </p>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $129.99
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h6 class="m-0">Sub Total:</h6>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            $1071.29
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h6 class="m-0">Shipping:</h6>
                                                                        </td>
                                                                        <td class="text-right">
                                                                            FREE
                                                                        </td>
                                                                    </tr>
                                                                    <tr class="text-right">
                                                                        <td>
                                                                            <h5 class="m-0">Total:</h5>
                                                                        </td>
                                                                        <td class="text-right font-weight-semibold">
                                                                            $1071.29
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <!-- end table-responsive -->
                                                    </div> <!-- end .border-->
        
                                                </div> <!-- end col -->            
                                            </div> <!-- end row-->
                                        </div>
                                        <!-- End Payment Information Content-->

                                    </div> <!-- end tab content-->

                                </div> <!-- end card-body-->
                            </div> <!-- end card-->
                        </div> <!-- end col -->
                    </div>
                    <!-- end row-->

                </div> <!-- container -->

            </div> <!-- content -->

            <!-- Footer Start -->
            <footer class="footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            2018 - 2019 Â© Hyper - Coderthemes.com
                        </div>
                        <div class="col-md-6">
                            <div class="text-md-right footer-links d-none d-md-block">
                                <a href="javascript: void(0);">About</a>
                                <a href="javascript: void(0);">Support</a>
                                <a href="javascript: void(0);">Contact Us</a>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- end Footer -->

        </div>

        <!-- ============================================================== -->
        <!-- End Page content -->
        <!-- ============================================================== -->


    </div>
    <!-- END wrapper -->


    <!-- Right Sidebar -->
    <div class="right-bar">

        <div class="rightbar-title">
            <a href="javascript:void(0);" class="right-bar-toggle float-right">
                <i class="dripicons-cross noti-icon"></i>
            </a>
            <h5 class="m-0">Settings</h5>
        </div>

        <div class="slimscroll-menu rightbar-content">

            <!-- Settings -->
            <hr class="mt-0" />
            <h5 class="pl-3">Basic Settings</h5>
            <hr class="mb-0" />

            <div class="p-3">
                <div class="custom-control custom-checkbox mb-2">
                    <input type="checkbox" class="custom-control-input" id="notifications-check" checked>
                    <label class="custom-control-label" for="notifications-check">Notifications</label>
                </div>

                <div class="custom-control custom-checkbox mb-2">
                    <input type="checkbox" class="custom-control-input" id="api-access-check">
                    <label class="custom-control-label" for="api-access-check">API Access</label>
                </div>

                <div class="custom-control custom-checkbox mb-2">
                    <input type="checkbox" class="custom-control-input" id="auto-updates-check" checked>
                    <label class="custom-control-label" for="auto-updates-check">Auto Updates</label>
                </div>

                <div class="custom-control custom-checkbox mb-2">
                    <input type="checkbox" class="custom-control-input" id="online-status-check" checked>
                    <label class="custom-control-label" for="online-status-check">Online Status</label>
                </div>

                <div class="custom-control custom-checkbox mb-2">
                    <input type="checkbox" class="custom-control-input" id="auto-payout-check">
                    <label class="custom-control-label" for="auto-payout-check">Auto Payout</label>
                </div>

            </div>


            <!-- Timeline -->
            <hr class="mt-0" />
            <h5 class="pl-3">Recent Activity</h5>
            <hr class="mb-0" />
            <div class="pl-2 pr-2">
                <div class="timeline-alt">
                    <div class="timeline-item">
                        <i class="mdi mdi-upload bg-info-lighten text-info timeline-icon"></i>
                        <div class="timeline-item-info">
                            <a href="#" class="text-info font-weight-bold mb-1 d-block">You sold an item</a>
                            <small>Paul Burgess just purchased âHyper - Admin Dashboardâ!</small>
                            <p class="mb-0 pb-2">
                                <small class="text-muted">5 minutes ago</small>
                            </p>
                        </div>
                    </div>

                    <div class="timeline-item">
                        <i class="mdi mdi-airplane bg-primary-lighten text-primary timeline-icon"></i>
                        <div class="timeline-item-info">
                            <a href="#" class="text-primary font-weight-bold mb-1 d-block">Product on the Bootstrap Market</a>
                            <small>Dave Gamache added
                                <span class="font-weight-bold">Admin Dashboard</span>
                            </small>
                            <p class="mb-0 pb-2">
                                <small class="text-muted">30 minutes ago</small>
                            </p>
                        </div>
                    </div>

                    <div class="timeline-item">
                        <i class="mdi mdi-microphone bg-info-lighten text-info timeline-icon"></i>
                        <div class="timeline-item-info">
                            <a href="#" class="text-info font-weight-bold mb-1 d-block">Robert Delaney</a>
                            <small>Send you message
                                <span class="font-weight-bold">"Are you there?"</span>
                            </small>
                            <p class="mb-0 pb-2">
                                <small class="text-muted">2 hours ago</small>
                            </p>
                        </div>
                    </div>

                    <div class="timeline-item">
                        <i class="mdi mdi-upload bg-primary-lighten text-primary timeline-icon"></i>
                        <div class="timeline-item-info">
                            <a href="#" class="text-primary font-weight-bold mb-1 d-block">Audrey Tobey</a>
                            <small>Uploaded a photo
                                <span class="font-weight-bold">"Error.jpg"</span>
                            </small>
                            <p class="mb-0 pb-2">
                                <small class="text-muted">14 hours ago</small>
                            </p>
                        </div>
                    </div>

                    <div class="timeline-item">
                        <i class="mdi mdi-upload bg-info-lighten text-info timeline-icon"></i>
                        <div class="timeline-item-info">
                            <a href="#" class="text-info font-weight-bold mb-1 d-block">You sold an item</a>
                            <small>Paul Burgess just purchased âHyper - Admin Dashboardâ!</small>
                            <p class="mb-0 pb-2">
                                <small class="text-muted">1 day ago</small>
                            </p>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>


    <div class="rightbar-overlay"></div>
    <!-- /Right-bar -->


    <!-- App js -->
   <%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp" %>
</body>

</html>