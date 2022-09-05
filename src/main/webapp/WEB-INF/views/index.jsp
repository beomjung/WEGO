<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="airbnb, booking, city guide, directory, events, hotel booking, listings, marketing, places, restaurant, restaurant">
    <meta name="description" content="Guido - Directory & Listing HTML Template">
    <meta name="CreativeLayers" content="ATFN">
    <!-- css file -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive stylesheet -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Title -->
    <title>Guido - Directory & Listing HTML Template</title>
    <!-- Favicon -->
    <link href="images/favicon.ico" sizes="128x128" rel="shortcut icon" type="image/x-icon" />
    <link href="images/favicon.ico" sizes="128x128" rel="shortcut icon" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="wrapper">
    <div class="preloader"></div>

    <!-- Main Header Nav -->
    <header class="header-nav menu_style_home_one navbar-scrolltofixed stricky main-menu">
        <div class="container-fluid p0">
            <!-- Ace Responsive Menu -->
            <nav>
                <!-- Menu Toggle btn-->
                <div class="menu-toggle">
                    <img class="nav_logo_img img-fluid" src="images/header-logo.svg" alt="header-logo.svg">
                    <button type="button" id="menu-btn">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <a href="index.html" class="navbar_brand float-left dn-smd">
                    <img class="logo1 img-fluid" src="images/header-logo.svg" alt="header-logo.svg">
                    <img class="logo2 img-fluid" src="images/header-logo2.svg" alt="header-logo2.svg">
                    <span>Guido</span>
                </a>
                <!-- Responsive Menu Structure-->
                <!--Note: declare the Menu style in the data-menu-style="horizontal" (options: horizontal, vertical, accordion) -->
                <div class="ht_left_widget float-left">
                    <ul>
                        <li class="list-inline-item">
                            <div class="ht_search_widget">
                                <div class="header_search_widget home1">
                                    <form class="form-inline mailchimp_form">
                                        <input type="text" class="custom_search_with_menu_trigger form-control" placeholder="What are you looking for?" data-toggle="modal" data-target="#staticBackdrop">
                                        <button type="submit" class="btn"><span class="flaticon-loupe"></span></button>
                                    </form>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <ul id="respMenu" class="ace-responsive-menu text-right" data-menu-style="horizontal">
                    <li>
                        <a href="#"><span class="title">Home</span></a>
                        <!-- Level Two-->
                        <ul>
                            <li><a href="index.html">Home V1</a></li>
                            <li><a href="index2.html">Home V2</a></li>
                            <li><a href="index3.html">Home V3</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="title">Explore</span></a>
                        <!-- Level Two-->
                        <ul>
                            <li><a href="page-author-single.html">Author Single</a></li>
                            <li><a href="page-city-single.html">City Single</a></li>
                            <li><a href="page-add-new-listing.html">New Listing</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="title">Listing</span></a>
                        <ul>
                            <li>
                                <a href="#">Listing Styles</a>
                                <!-- Level Three-->
                                <ul>
                                    <li><a href="page-listing-v1.html">Listing v1</a></li>
                                    <li><a href="page-listing-v2.html">Listing v2</a></li>
                                    <li><a href="page-listing-v3.html">Listing v3</a></li>
                                    <li><a href="page-listing-v4.html">Listing v4</a></li>
                                    <li><a href="page-listing-v5.html">Listing v5</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Listing Map</a>
                                <!-- Level Three-->
                                <ul>
                                    <li><a href="page-listing-v6.html">Map v1</a></li>
                                    <li><a href="page-listing-v7.html">Map v2</a></li>
                                    <li><a href="page-listing-v8.html">Map v3</a></li>
                                    <li><a href="page-listing-v9.html">Map v4</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Listing Single</a>
                                <!-- Level Three-->
                                <ul>
                                    <li><a href="page-listing-single-v1.html">Single V1</a></li>
                                    <li><a href="page-listing-single-v2.html">Single V2</a></li>
                                    <li><a href="page-listing-single-v3.html">Single V3</a></li>
                                </ul>
                            </li>
                            <li><a href="page-add-new-listing.html">New Listing</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="title">Pages</span></a>
                        <ul>
                            <li>
                                <a href="#"><span class="title">Shop Pages</span></a>
                                <ul>
                                    <li><a href="page-shop.html">Shop</a></li>
                                    <li><a href="page-shop-single.html">Shop Single</a></li>
                                    <li><a href="page-shop-cart.html">Cart</a></li>
                                    <li><a href="page-shop-checkout.html">Checkout</a></li>
                                    <li><a href="page-shop-order.html">Order</a></li>
                                </ul>
                            </li>
                            <li><a href="page-about.html">About Us</a></li>
                            <li><a href="page-contact.html">Contact</a></li>
                            <li><a href="page-coming-soon.html">Coming Soon</a></li>
                            <li>
                                <a href="#">User Dashboard</a>
                                <ul>
                                    <li><a href="page-my-dashboard.html">Dashboard</a></li>
                                    <li><a href="page-profile.html">My Profile</a></li>
                                    <li><a href="page-my-listing.html">My Listings</a></li>
                                    <li><a href="page-my-bookmark.html">Bookmarks</a></li>
                                    <li><a href="page-message.html">Messages</a></li>
                                    <li><a href="page-my-review.html">Reviews</a></li>
                                    <li><a href="page-add-new-listing.html">Add New Property</a></li>
                                </ul>
                            </li>
                            <li><a href="page-gallery.html">Gallery</a></li>
                            <li><a href="page-faq.html">Faq</a></li>
                            <li><a href="page-invoice.html">Invoice</a></li>
                            <li><a href="page-login.html">LogIn</a></li>
                            <li><a href="page-pricing.html">Pricing V1</a></li>
                            <li><a href="page-pricing2.html">Pricing V2</a></li>
                            <li><a href="page-register.html">Register</a></li>
                            <li><a href="page-error.html">404 Page</a></li>
                            <li><a href="page-terms.html">Terms and Conditions</a></li>
                            <li><a href="page-ui-element.html">UI Elements</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="title">Blog</span></a>
                        <ul>
                            <li><a href="page-blog-grid.html">Blog Grid</a></li>
                            <li><a href="page-blog-grid-sidebar.html">Blog Grid Sidebar</a></li>
                            <li><a href="page-blog-details.html">Blog Details</a></li>
                            <li><a href="page-blog-list.html">Blog List</a></li>
                            <li><a href="page-blog-single.html">Blog Single</a></li>
                        </ul>
                    </li>
                    <li class="list-inline-item list_s"><a href="#" class="btn flaticon-avatar" data-toggle="modal" data-target=".bd-example-modal-lg"> <span class="dn-1200">Login/Sign Up</span></a></li>
                    <li class="list-inline-item add_listing"><a href="page-add-new-listing.html"><span class="icon">+</span><span class="dn-lg"> Add Listing</span></a></li>
                </ul>
            </nav>
        </div>
    </header>
    <!-- Modal -->
    <div class="sign_up_modal modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md mt100" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body container pb20 pl0 pr0 pt0">
                    <div class="row">
                        <div class="col-lg-12">
                            <ul class="sign_up_tab nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Sign in</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Register</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="tab-content container" id="myTabContent">
                        <div class="row mt40 tab-pane fade show active pl20 pr20" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="col-lg-12">
                                <div class="login_form">
                                    <form action="#">
                                        <div class="input-group mb-2 mr-sm-2">
                                            <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Username / Email">
                                        </div>
                                        <div class="input-group form-group mb5">
                                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                        </div>
                                        <div class="form-group custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="exampleCheck1">
                                            <label class="custom-control-label" for="exampleCheck1">Remember me</label>
                                            <a class="btn-fpswd float-right" href="#">Forgot password?</a>
                                        </div>
                                        <button type="submit" class="btn btn-log btn-block btn-thm">Sign in</button>
                                        <p class="text-center mb30 mt20">Don't have an account? <a class="text-thm" href="#">Sign up</a></p>
                                        <hr>
                                        <div class="row mt30">
                                            <div class="col-lg-6">
                                                <button type="submit" class="btn btn-fb btn-block"><i class="fa fa-facebook float-left mt5"></i> Log In via Facebook</button>
                                            </div>
                                            <div class="col-lg-6">
                                                <button type="submit" class="btn btn-googl btn-block"><i class="fa fa-google float-left mt5"></i> Log In via Google+</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="row mt40 tab-pane fade pl20 pr20" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <div class="col-lg-12">
                                <div class="sign_up_form">
                                    <ul class="nav nav-pills mb-4" id="pills-tab" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Customer</a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Business Owner</a>
                                        </li>
                                    </ul>
                                    <div class="tab-content" id="pills-tabContent">
                                        <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                                            <form action="#">
                                                <div class="form-group input-group">
                                                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email">
                                                </div>
                                                <div class="form-group input-group">
                                                    <input type="text" class="form-control" id="exampleInputName" placeholder="Username">
                                                </div>
                                                <div class="form-group input-group mb20">
                                                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
                                                </div>
                                                <button type="submit" class="btn btn-log btn-block btn-thm">Sign Up</button>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-lg-6">
                                                        <button type="submit" class="btn btn-block btn-fb"><i class="fa fa-facebook float-left mt5"></i> Log In via Facebook</button>
                                                    </div>
                                                    <div class="col-lg-6">
                                                        <button type="submit" class="btn btn-block btn-googl"><i class="fa fa-google float-left mt5"></i> Log In via Google+</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                                            <form action="#">
                                                <div class="form-group input-group">
                                                    <input type="email" class="form-control" id="exampleInputEmail3" placeholder="Email">
                                                </div>
                                                <div class="form-group input-group">
                                                    <input type="text" class="form-control" id="exampleInputName2" placeholder="Username">
                                                </div>
                                                <div class="form-group input-group mb20">
                                                    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
                                                </div>
                                                <button type="submit" class="btn btn-log btn-block btn-thm">Sign Up</button>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-lg-6">
                                                        <button type="submit" class="btn btn-block btn-fb"><i class="fa fa-facebook float-left mt5"></i> Log In via Facebook</button>
                                                    </div>
                                                    <div class="col-lg-6">
                                                        <button type="submit" class="btn btn-block btn-googl"><i class="fa fa-google float-left mt5"></i> Log In via Google+</button>
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
            </div>
        </div>
    </div>

    <!-- Main Header Nav For Mobile -->
    <div id="page" class="stylehome1 h0">
        <div class="mobile-menu">
            <div class="header stylehome1">
                <div class="main_logo_home2 text-left">
                    <img class="nav_logo_img img-fluid mt15" src="images/header-logo2.svg" alt="header-logo2.svg">
                    <span class="mt15">Guido</span>
                </div>
                <ul class="menu_bar_home2">
                    <li class="list-inline-item"><a class="custom_search_with_menu_trigger msearch_icon" href="#" data-toggle="modal" data-target="#staticBackdrop"><span class="flaticon-loupe"></span></a></li>
                    <li class="list-inline-item"><a class="muser_icon" href="page-register.html"><span class="flaticon-avatar"></span></a></li>
                    <li class="list-inline-item"><a class="menubar" href="#menu"><span></span></a></li>
                </ul>
            </div>
        </div><!-- /.mobile-menu -->
        <nav id="menu" class="stylehome1">
            <ul>
                <li><span>Home</span>
                    <ul>
                        <li><a href="index.html">Home V1</a></li>
                        <li><a href="index2.html">Home V2</a></li>
                        <li><a href="index3.html">Home V3</a></li>
                    </ul>
                </li>
                <li><span>Explore</span>
                    <ul>
                        <li><a href="page-author-single.html">Author Single</a></li>
                        <li><a href="page-city-single.html">City Single</a></li>
                        <li><a href="page-add-new-listing.html">New Listing</a></li>
                    </ul>
                </li>
                <li><span>Listing</span>
                    <ul>
                        <li><span>Listing Styles</span>
                            <ul>
                                <li><a href="page-listing-v1.html">Listing v1</a></li>
                                <li><a href="page-listing-v2.html">Listing v2</a></li>
                                <li><a href="page-listing-v3.html">Listing v3</a></li>
                                <li><a href="page-listing-v4.html">Listing v4</a></li>
                                <li><a href="page-listing-v5.html">Listing v5</a></li>
                            </ul>
                        </li>
                        <li><span>Listing Map</span>
                            <ul>
                                <li><a href="page-listing-v6.html">Map v1</a></li>
                                <li><a href="page-listing-v7.html">Map v2</a></li>
                                <li><a href="page-listing-v8.html">Map v3</a></li>
                                <li><a href="page-listing-v9.html">Map v4</a></li>
                            </ul>
                        </li>
                        <li><span>Listing Single</span>
                            <ul>
                                <li><a href="page-listing-single-v1.html">Single V1</a></li>
                                <li><a href="page-listing-single-v2.html">Single V2</a></li>
                                <li><a href="page-listing-single-v3.html">Single V3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><span>Blog</span>
                    <ul>
                        <li><a href="page-blog-grid.html">Blog Grid</a></li>
                        <li><a href="page-blog-grid-sidebar.html">Blog Grid Sidebar</a></li>
                        <li><a href="page-blog-details.html">Blog Details</a></li>
                        <li><a href="page-blog-list.html">Blog List</a></li>
                        <li><a href="page-blog-single.html">Blog Single</a></li>
                    </ul>
                </li>
                <li><span>Pages</span>
                    <ul>
                        <li><span>Shop</span>
                            <ul>
                                <li><a href="page-shop.html">Shop Pages</a></li>
                                <li><a href="page-shop-single.html">Shop Single</a></li>
                                <li><a href="page-shop-cart.html">Cart</a></li>
                                <li><a href="page-shop-checkout.html">Checkout</a></li>
                                <li><a href="page-shop-order.html">Order</a></li>
                            </ul>
                        </li>
                        <li><a href="page-about.html">About Us</a></li>
                        <li><a href="page-contact.html">Contact</a></li>
                        <li><a href="page-coming-soon.html">Coming Soon</a></li>
                        <li><span>User Detils</span>
                            <ul>
                                <li><a href="page-my-dashboard.html">Dashboard</a></li>
                                <li><a href="page-profile.html">My Profile</a></li>
                                <li><a href="page-my-listing.html">My Listings</a></li>
                                <li><a href="page-my-bookmark.html">Bookmarks</a></li>
                                <li><a href="page-message.html">Messages</a></li>
                                <li><a href="page-my-review.html">Reviews</a></li>
                                <li><a href="page-add-new-listing.html">Add New Property</a></li>
                            </ul>
                        </li>
                        <li><a href="page-gallery.html">Gallery</a></li>
                        <li><a href="page-faq.html">Faq</a></li>
                        <li><a href="page-invoice.html">Invoice</a></li>
                        <li><a href="page-login.html">LogIn</a></li>
                        <li><a href="page-pricing.html">Pricing V1</a></li>
                        <li><a href="page-pricing2.html">Pricing V2</a></li>
                        <li><a href="page-register.html">Register</a></li>
                        <li><a href="page-error.html">404 Page</a></li>
                        <li><a href="page-terms.html">Terms and Conditions</a></li>
                        <li><a href="page-ui-element.html">UI Elements</a></li>
                    </ul>
                </li>
                <li><a href="page-contact.html">Contact</a></li>
                <li><a href="page-login.html"><span class="flaticon-avatar"></span> Login</a></li>
                <li><a href="page-register.html"><span class="flaticon-edit"></span> Register</a></li>
                <li class="cl_btn"><a class="btn btn-block btn-lg btn-thm rounded" href="#"><span class="icon">+</span> Create Listing</a></li>
            </ul>
        </nav>
    </div>

    <!-- Search Field Modal -->
    <section class="modal fade search_dropdown" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="popup_modal_wrapper">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-12">
                                    <a class="close closer" data-dismiss="modal" aria-label="Close" href="#"><span><img src="images/icons/close.svg" alt=""></span></a>
                                </div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 mb30">
                                    <h3>Filter by Category</h3>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl-2">
                                    <div class="icon-box text-center">
                                        <div class="icon"><span class="flaticon-cutlery"></span></div>
                                        <div class="content-details">
                                            <div class="title">Restaurant</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl-2">
                                    <div class="icon-box text-center">
                                        <div class="icon"><span class="flaticon-shopping-bag"></span></div>
                                        <div class="content-details">
                                            <div class="title">Shopping</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl-2">
                                    <div class="icon-box text-center">
                                        <div class="icon"><span class="flaticon-tent"></span></div>
                                        <div class="content-details">
                                            <div class="title">Outdoor Activities</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl-2">
                                    <div class="icon-box text-center">
                                        <div class="icon"><span class="flaticon-desk-bell"></span></div>
                                        <div class="content-details">
                                            <div class="title">Hotels</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl-2">
                                    <div class="icon-box text-center">
                                        <div class="icon"><span class="flaticon-mirror"></span></div>
                                        <div class="content-details">
                                            <div class="title">Beautu & Spa</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl-2">
                                    <div class="icon-box text-center">
                                        <div class="icon"><span class="flaticon-brake"></span></div>
                                        <div class="content-details">
                                            <div class="title">Automotive</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 mb15 mt20">
                                    <h3>Explore Hot Location</h3>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc18.jpg" alt="pc18.jpg"></div>
                                        <div class="details">
                                            <h4>Miami</h4>
                                            <p>62 Listings</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc19.jpg" alt="pc19.jpg"></div>
                                        <div class="details">
                                            <h4>Roma</h4>
                                            <p>92 Listings</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc20.jpg" alt="pc20.jpg"></div>
                                        <div class="details">
                                            <h4>New Delhi</h4>
                                            <p>12 Listings</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc21.jpg" alt="pc21.jpg"></div>
                                        <div class="details">
                                            <h4>London</h4>
                                            <p>74 Listings</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc22.jpg" alt="pc22.jpg"></div>
                                        <div class="details">
                                            <h4>Amsterdam</h4>
                                            <p>62 Listings</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc23.jpg" alt="pc23.jpg"></div>
                                        <div class="details">
                                            <h4>Berlin</h4>
                                            <p>92 Listings</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc24.jpg" alt="pc24.jpg"></div>
                                        <div class="details">
                                            <h4>Paris</h4>
                                            <p>12 Listings</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                                    <div class="property_city_home6 tac-xsd">
                                        <div class="thumb"><img class="w100" src="images/property/pc25.jpg" alt="pc25.jpg"></div>
                                        <div class="details">
                                            <h4>New Zealand</h4>
                                            <p>74 Listings</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Home Design -->
    <section class="home-one home1-overlay bg-img1">
        <div class="container">
            <div class="row posr">
                <div class="col-lg-12">
                    <div class="home_content home1">
                        <div class="home-text text-center">
                            <h2 class="fz50">Explore Amazing Destinations</h2>
                            <p class="fz18 color-white">Find great places to stay, eat, shop, or visit from local experts.</p>
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-lg-10 col-xl-8">
                                <div class="home_adv_srch_opt text-center">
                                    <div class="wrapper">
                                        <div class="home_adv_srch_form">
                                            <form class="bgc-white bgct-767 pl30 pt10 pl0-767" action="/search" method="get">
                                                <input type="hidden" value="KOR" name="languageType">
                                                <div class="form-row align-items-center">
                                                    <div class="col-auto home_form_input mb20-xsd">
                                                        <label class="sr-only">Username</label>
                                                        <div class="input-group style1 mb-2 mb0-767">
                                                            <div class="input-group-prepend">
                                                                <div class="input-group-text pl0 pb0-767">What</div>
                                                            </div>
                                                            <div class="select-wrap style1-dropdown">
                                                                <select class="form-control js-searchBox" name="contentType">
                                                                    <option value="">Ex: shopping, restaurant...</option>
                                                                    <option value="TopPicks">Top Picks</option>
                                                                    <option value="CityOfLondon">City of London</option>
                                                                    <option value="LEPORTS">Outdoor Activities</option>
                                                                    <option value="RESTAURANTS">Restaurant</option>
                                                                    <option value="LODGING">Hotels</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-auto home_form_input">
                                                        <label class="sr-only">Username</label>
                                                        <div class="input-group style2 mb-2 mb0-767">
                                                            <div class="input-group-prepend">
                                                                <div class="input-group-text pb0-767">Where</div>
                                                            </div>
                                                            <div class="select-wrap style2-dropdown">
                                                                <select class="form-control js-searchBox2" name="contentType">
                                                                    <option value="">Your City</option>
                                                                    <option value="1">New York</option>
                                                                    <option value="2">London</option>
                                                                    <option value="3">Paris</option>
                                                                    <option value="4">Istanbul</option>
                                                                    <option value="5">Los Angeles</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-auto home_form_input2">
                                                        <button type="submit" class="btn search-btn mb-2"><span class="flaticon-loupe"></span></button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="home_mobile_slider home_custom_list dn db-767">
                                        <div class="item">
                                            <div class="icon_home1">
                                                <div class="icon"><span class="flaticon-cutlery"></span></div>
                                                <p>Restaurant</p>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <div class="icon_home1">
                                                <div class="icon"><span class="flaticon-shopping-bag"></span></div>
                                                <p>Shopping</p>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <div class="icon_home1">
                                                <div class="icon"><span class="flaticon-tent"></span></div>
                                                <p>Outdoor Activities</p>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <div class="icon_home1">
                                                <div class="icon"><span class="flaticon-desk-bell"></span></div>
                                                <p>Hotels</p>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <div class="icon_home1">
                                                <div class="icon"><span class="flaticon-mirror"></span></div>
                                                <p>Beautu & Spa</p>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <div class="icon_home1">
                                                <div class="icon"><span class="flaticon-brake"></span></div>
                                                <p>Automotive</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Feature Properties -->
    <section id="feature-property" class="feature-property pt0 border-bottom">
        <div class="container p0">
            <div class="feature-content dn-767">
                <div class="row justify-content-center mt-80 mb45">
                    <div class="col-lg-4 text-center">
                        <p><em class="text-white">What are you interested in?</em></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-md-4 col-xl-2">
                        <div class="icon-box text-center">
                            <div class="icon"><span class="flaticon-cutlery"></span></div>
                            <div class="content-details">
                                <div class="title">Restaurant</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-xl-2">
                        <div class="icon-box text-center">
                            <div class="icon"><span class="flaticon-shopping-bag"></span></div>
                            <div class="content-details">
                                <div class="title">Shopping</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-xl-2">
                        <div class="icon-box text-center">
                            <div class="icon"><span class="flaticon-tent"></span></div>
                            <div class="content-details">
                                <div class="title">Outdoor Activities</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-xl-2">
                        <div class="icon-box text-center">
                            <div class="icon"><span class="flaticon-desk-bell"></span></div>
                            <div class="content-details">
                                <div class="title">Hotels</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-xl-2">
                        <div class="icon-box text-center">
                            <div class="icon"><span class="flaticon-mirror"></span></div>
                            <div class="content-details">
                                <div class="title">Beautu & Spa</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-xl-2">
                        <div class="icon-box text-center">
                            <div class="icon"><span class="flaticon-brake"></span></div>
                            <div class="content-details">
                                <div class="title">Automotive</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container pt100-767">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="main-title text-center">
                        <h2>The Most Popular Things to Do in the City</h2>
                        <p>Discover some of the most popular listings in Toronto based on user reviews and ratings.</p>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="popular_listing_slider1">
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp1.jpg" alt="fp1.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="tag2 mb0">
                                            <li class="list-inline-item"><a href="#">Featured</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent1.svg" alt="agent1.svg"></a></div>
                                        <h4>Adventure High Ropes</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon3.svg" alt="icon3.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Outdoor Activities</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp2.jpg" alt="fp2.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent2.svg" alt="agent2.svg"></a></div>
                                        <h4>Amrutha Lounge</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon4.svg" alt="icon4.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp3.jpg" alt="fp3.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent3.svg" alt="agent3.svg"></a></div>
                                        <h4>The Waldorf Hilton</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon5.svg" alt="icon5.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp1.jpg" alt="fp1.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="tag2 mb0">
                                            <li class="list-inline-item"><a href="#">Featured</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent1.svg" alt="agent1.svg"></a></div>
                                        <h4>Adventure High Ropes</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon3.svg" alt="icon3.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Outdoor Activities</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp2.jpg" alt="fp2.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent2.svg" alt="agent2.svg"></a></div>
                                        <h4>Amrutha Lounge</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon4.svg" alt="icon4.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp3.jpg" alt="fp3.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent3.svg" alt="agent3.svg"></a></div>
                                        <h4>The Waldorf Hilton</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon5.svg" alt="icon5.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp1.jpg" alt="fp1.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="tag2 mb0">
                                            <li class="list-inline-item"><a href="#">Featured</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent1.svg" alt="agent1.svg"></a></div>
                                        <h4>Adventure High Ropes</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon3.svg" alt="icon3.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Outdoor Activities</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp2.jpg" alt="fp2.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent2.svg" alt="agent2.svg"></a></div>
                                        <h4>Amrutha Lounge</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon4.svg" alt="icon4.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp3.jpg" alt="fp3.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent3.svg" alt="agent3.svg"></a></div>
                                        <h4>The Waldorf Hilton</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon5.svg" alt="icon5.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp1.jpg" alt="fp1.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="tag2 mb0">
                                            <li class="list-inline-item"><a href="#">Featured</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent1.svg" alt="agent1.svg"></a></div>
                                        <h4>Adventure High Ropes</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon3.svg" alt="icon3.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Outdoor Activities</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp2.jpg" alt="fp2.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent2.svg" alt="agent2.svg"></a></div>
                                        <h4>Amrutha Lounge</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon4.svg" alt="icon4.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="feat_property">
                                <div class="thumb">
                                    <img class="img-whp" src="images/property/fp3.jpg" alt="fp3.jpg">
                                    <div class="thmb_cntnt">
                                        <ul class="tag mb0">
                                            <li class="list-inline-item"><a href="#">$$$$</a></li>
                                            <li class="list-inline-item"><a href="#">Open</a></li>
                                        </ul>
                                        <ul class="listing_reviews">
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white" href="#"><span class="fa fa-star"></span></a></li>
                                            <li class="list-inline-item"><a class="text-white total_review" href="#">(5 Review)</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="details">
                                    <div class="tc_content">
                                        <div class="badge_icon"><a href="#"><img src="images/icons/agent3.svg" alt="agent3.svg"></a></div>
                                        <h4>The Waldorf Hilton</h4>
                                        <p>But I must explain to you how all this mistaken idea...</p>
                                        <ul class="prop_details mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-phone pr5"></span> +61-8181-123</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-pin pr5"></span> New York</a></li>
                                        </ul>
                                    </div>
                                    <div class="fp_footer">
                                        <ul class="fp_meta float-left mb0">
                                            <li class="list-inline-item"><a href="#"><img src="images/icons/icon5.svg" alt="icon5.svg"></a></li>
                                            <li class="list-inline-item"><a href="#">Restaurant</a></li>
                                        </ul>
                                        <ul class="fp_meta float-right mb0">
                                            <li class="list-inline-item"><a href="#"><span class="flaticon-zoom"></span></a></li>
                                            <li class="list-inline-item"><a class="icon" href="#"><span class="flaticon-love"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Property Cities -->
    <section id="property-city" class="property-city pb70">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="main-title text-center">
                        <h2>Trending Cities</h2>
                        <p>Cities You Must Explore This Summer</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-8 col-xl-8">
                    <div class="properti_city">
                        <div class="thumb"><img class="img-fluid w100" src="images/property/pc2.jpg" alt="pc2.jpg"></div>
                        <div class="overlay">
                            <div class="details">
                                <h4>Miami</h4>
                                <p>62 Listing</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="properti_city">
                        <div class="thumb"><img class="img-fluid w100" src="images/property/pc1.jpg" alt="pc1.jpg"></div>
                        <div class="overlay">
                            <div class="details">
                                <h4>Los Angeles</h4>
                                <p>45 Listing</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="properti_city">
                        <div class="thumb"><img class="img-fluid w100" src="images/property/pc4.jpg" alt="pc4.jpg"></div>
                        <div class="overlay">
                            <div class="details">
                                <h4>Florida</h4>
                                <p>86 Listing</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-8 col-xl-8">
                    <div class="properti_city">
                        <div class="thumb"><img class="img-fluid w100" src="images/property/pc3.jpg" alt="pc3.jpg"></div>
                        <div class="overlay">
                            <div class="details">
                                <h4>New York</h4>
                                <p>21 Listing</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- How It Works -->
    <section id="why-chose" class="whychose_us bgc-f7 pb70">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="main-title text-center">
                        <h2>How it Works</h2>
                        <p>Bringing business and community members together.</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="why_chose_us">
                        <div class="icon">
                            <span class="flaticon-find-location"></span>
                        </div>
                        <div class="details">
                            <h4>Find Businesses</h4>
                            <p>Discover & connect with great local businesses in your local neighborhood like dentists, hair stylists and more.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="why_chose_us">
                        <div class="icon">
                            <span class="flaticon-comment"></span>
                        </div>
                        <div class="details">
                            <h4>Review Listings</h4>
                            <p>Discover & connect with great local businesses in your local neighborhood like dentists, hair stylists and more.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="why_chose_us">
                        <div class="icon">
                            <span class="flaticon-date"></span>
                        </div>
                        <div class="details">
                            <h4>Make a Reservation</h4>
                            <p>Discover & connect with great local businesses in your local neighborhood like dentists, hair stylists and more.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Our Testimonials -->
    <section class="our-testimonials">
        <div class="container ovh max1800">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="main-title text-center">
                        <h2>Testimonials From Our Customers</h2>
                        <p>Lorem ipsum dolor sit amet elit, sed do eiusmod tempor</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="testimonial_slider_home1">
                        <div class="item">
                            <div class="testimonial_post text-center">
                                <div class="thumb">
                                    <img src="images/testimonial/1.png" alt="1.png">
                                    <h4 class="title">Alison Dawn</h4>
                                    <div class="client-postn">WordPress Developer</div>
                                </div>
                                <div class="details">
                                    <div class="icon"><span>“</span></div>
                                    <p>“ I believe in lifelong learning and Skola is a great place to learn from experts. I've learned a lot and recommend it to all my friends “</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="testimonial_post text-center">
                                <div class="thumb">
                                    <img src="images/testimonial/2.png" alt="2.png">
                                    <h4 class="title">Albert Cole</h4>
                                    <div class="client-postn">Designer</div>
                                </div>
                                <div class="details">
                                    <div class="icon"><span>“</span></div>
                                    <p>“ I believe in lifelong learning and Skola is a great place to learn from experts. I've learned a lot and recommend it to all my friends “</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="testimonial_post text-center">
                                <div class="thumb">
                                    <img src="images/testimonial/3.png" alt="3.png">
                                    <h4 class="title">Daniel Parker</h4>
                                    <div class="client-postn">Front-end Developer</div>
                                </div>
                                <div class="details">
                                    <div class="icon"><span>“</span></div>
                                    <p>“ I believe in lifelong learning and Skola is a great place to learn from experts. I've learned a lot and recommend it to all my friends “</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="testimonial_post text-center">
                                <div class="thumb">
                                    <img src="images/testimonial/2.png" alt="2.png">
                                    <h4 class="title">Alison Dawn</h4>
                                    <div class="client-postn">WordPress Developer</div>
                                </div>
                                <div class="details">
                                    <div class="icon"><span>“</span></div>
                                    <p>“ I believe in lifelong learning and Skola is a great place to learn from experts. I've learned a lot and recommend it to all my friends “</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="testimonial_post text-center">
                                <div class="thumb">
                                    <img src="images/testimonial/1.png" alt="1.png">
                                    <h4 class="title">Albert Cole</h4>
                                    <div class="client-postn">Designer</div>
                                </div>
                                <div class="details">
                                    <div class="icon"><span>“</span></div>
                                    <p>“ I believe in lifelong learning and Skola is a great place to learn from experts. I've learned a lot and recommend it to all my friends “</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Our Divider -->
    <section class="divider home-style1 parallax" data-stellar-background-ratio="0.2">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="business_exposer text-center">
                        <h2 class="title text-white mb20">Get Business Exposure</h2>
                        <p class="text-white mb35">Your business deserves efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time schemas.</p>
                        <a class="btn exposer_btn" href="#">How It Works</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Our Blog -->
    <section class="our-blog pb70">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="main-title text-center">
                        <h2>News & Tips</h2>
                        <p>Checkout Latest News And Articles From Our Blog.</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="for_blog feat_property">
                        <div class="thumb">
                            <img class="img-whp" src="images/blog/1.jpg" alt="1.jpg">
                            <div class="tag bgc-thm"><a class="text-white" href="#">Health & Care</a></div>
                        </div>
                        <div class="details">
                            <div class="tc_content">
                                <div class="bp_meta">
                                    <ul>
                                        <li class="list-inline-item"><a href="#"><span class="flaticon-avatar mr10"></span> Jack Wilson</a></li>
                                        <li class="list-inline-item"><a href="#"><span class="flaticon-date mr10"></span> 06 April, 2020</a></li>
                                    </ul>
                                </div>
                                <h4>The Top 25 Bike Stores in Toronto by Neighbourhood</h4>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="for_blog feat_property">
                        <div class="thumb">
                            <img class="img-whp" src="images/blog/2.jpg" alt="2.jpg">
                            <div class="tag bgc-thm"><a class="text-white" href="#">Culture</a></div>
                        </div>
                        <div class="details">
                            <div class="tc_content">
                                <div class="bp_meta">
                                    <ul>
                                        <li class="list-inline-item"><a href="#"><span class="flaticon-avatar mr10"></span> Jack Wilson</a></li>
                                        <li class="list-inline-item"><a href="#"><span class="flaticon-date mr10"></span> 06 April, 2020</a></li>
                                    </ul>
                                </div>
                                <h4>How to Wear a Headscarf Like a Gucci Muse</h4>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="for_blog feat_property">
                        <div class="thumb">
                            <img class="img-whp" src="images/blog/3.jpg" alt="3.jpg">
                            <div class="tag bgc-thm"><a class="text-white" href="#">Travelling</a></div>
                        </div>
                        <div class="details">
                            <div class="tc_content">
                                <div class="bp_meta">
                                    <ul>
                                        <li class="list-inline-item"><a href="#"><span class="flaticon-avatar mr10"></span> Jack Wilson</a></li>
                                        <li class="list-inline-item"><a href="#"><span class="flaticon-date mr10"></span> 06 April, 2020</a></li>
                                    </ul>
                                </div>
                                <h4>Quisque sed eros mollis, pretium odio feugiat dictum</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Start Partners -->
    <section class="start-partners home1 bgc-thm pt60 pb60">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="start_partner tac-smd">
                        <h2>Submit Your Property Today!</h2>
                        <p>Explore some of the best tips from around the city from our partners and friends.</p>
                    </div>
                </div>
                <div class="col-lg-4 pr10">
                    <div class="parner_reg_btn text-right tac-smd">
                        <a class="btn" href="#">Submit Now</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Our Footer -->
    <section class="footer_one home1">
        <div class="container pb70">
            <div class="row">
                <div class="col-sm-6 col-md-6 col-lg-3 col-xl-3">
                    <div class="footer_contact_widget">
                        <h4>Contact Us</h4>
                        <ul class="list-unstyled">
                            <li class="text-white df"><span class="flaticon-pin mr15"></span><a href="#">329 Queensberry Street, North Melbourne VIC 3051, Australia.</a></li>
                            <li class="text-white"><span class="flaticon-phone mr15"></span><a href="#">+123 456 7890</a></li>
                            <li class="text-white"><span class="flaticon-email mr15"></span><a href="#">support@skola.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-md-6 col-lg-2 col-xl-3">
                    <div class="footer_qlink_widget">
                        <h4>Company</h4>
                        <ul class="list-unstyled">
                            <li><a href="#">Help Center</a></li>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Career</a></li>
                            <li><a href="#">How It Works</a></li>
                            <li><a href="#">Article & Tips</a></li>
                            <li><a href="#">Terms & Service</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-5 col-md-6 col-lg-2 col-xl-2">
                    <div class="footer_qlink_widget pl0">
                        <h4>Discover</h4>
                        <ul class="list-unstyled">
                            <li><a href="#">Chicago</a></li>
                            <li><a href="#">Los Angels</a></li>
                            <li><a href="#">Miami</a></li>
                            <li><a href="#">New York</a></li>
                            <li><a href="#">Florida</a></li>
                            <li><a href="#">Boston</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-7 col-md-6 col-lg-4 col-xl-4">
                    <div class="footer_social_widget">
                        <h4>Subscribe</h4>
                        <p class="text-white mb20">We don’t send spam so don’t worry.</p>
                        <form class="footer_mailchimp_form">
                            <div class="form-row align-items-center">
                                <div class="col-auto">
                                    <input type="email" class="form-control" id="inlineFormInput" placeholder="Enter your email" required>
                                    <button type="submit" class="btn btn-primary">Subscribe</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <div class="container pt20 pb30">
            <div class="row">
                <div class="col-md-4 col-lg-4">
                    <div class="copyright-widget mt10 mb15-767">
                        <p>© Guido - All rights reserved.</p>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="footer_logo_widget text-center mb15-767">
                        <div class="wrapper">
                            <div class="logo text-center">
                                <img src="images/footer-logo.svg" alt="footer-logo.svg">
                                <span class="logo_title text-white pl15">Guido</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="footer_social_widget text-right tac-smd mt10">
                        <ul class="mb0">
                            <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li class="list-inline-item"><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li class="list-inline-item"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <a class="scrollToHome" href="#"><i class="fa fa-angle-up"></i></a>
</div>
<!-- Wrapper End -->
<script src="js/jquery-3.6.0.js"></script>
<script src="js/jquery-migrate-3.0.0.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.mmenu.all.js"></script>
<script src="js/ace-responsive-menu.js"></script>
<script src="js/bootstrap-select.min.js"></script>
<script src="js/isotop.js"></script>
<script src="js/snackbar.min.js"></script>
<script src="js/simplebar.js"></script>
<script src="js/parallax.js"></script>
<script src="js/scrollto.js"></script>
<script src="js/jquery-scrolltofixed-min.js"></script>
<script src="js/jquery.counterup.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/progressbar.js"></script>
<script src="js/slider.js"></script>
<script src="js/timepicker.js"></script>
<!-- Custom script for all pages -->
<script src="js/script.js"></script>
</body>
</html>