<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%> 
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>--%>
<style>
body { -webkit-font-smoothing: antialiased; text-rendering: optimizeLegibility; font-family: 'Source Sans Pro', sans-serif; letter-spacing: 0px; font-size: 17px; color: #6d767a; font-weight: 400; line-height: 34px; }
h1, h2, h3, h4, h5, h6 { color: #161f23; margin: 0px 0px 15px 0px; font-family: 'Source Sans Pro', sans-serif; font-weight: 700; }
h1 { font-size: 42px; }
h2 { font-size: 32px; }
h3 { font-size: 24px; }
h4 { font-size: 20px; }
h5 { font-size: 14px; }
h6 { font-size: 12px; }
p { margin: 0 0 20px; line-height: 1.7; }
p:last-child { margin: 0px; }
ul, ol { }
a { text-decoration: none; color: #6d767a; -webkit-transition: all 0.3s; -moz-transition: all 0.3s; transition: all 0.3s; }
a:focus, a:hover { text-decoration: none; color: #235f83; }
hr { border-top: 1px solid #e4e7e9; margin-bottom: 50px; margin-top: 50px; }

.btn { font-family: 'Source Sans Pro', sans-serif; font-size: 16px; text-transform: capitalize; font-weight: 700; padding: 12px 24px; letter-spacing: 0px; border-radius: 3px; line-height: 2; -webkit-transition: all 0.5s; -moz-transition: all 0.5s; transition: all 0.5s; word-wrap: break-word; white-space: normal !important; }

.btn-default { background-color: #ff9f2a; color: #fff; border: 1px solid #ff9f2a; }
.btn-default:hover { background-color: #ec8a13; color: #fff; border: 1px solid #ec8a13; }
.btn-default.focus, .btn-default:focus { background-color: #ec8a13; color: #fff; border: 1px solid #ec8a13; box-shadow: 0 0 0 0.1rem rgb(236, 138, 19); }


.form-control { border-radius: 0px; font-size: 14px; font-weight: 700; width: 100%; height: 64px; padding: 16px 20px; line-height: 1.42857143; border: 1px solid #d6dadc; background-color: #fff; text-transform: capitalize; letter-spacing: 0px; margin-bottom: 30px; -webkit-box-shadow: inset 0 0px 0px rgba(0, 0, 0, 0); box-shadow: inset 0 0px 0px rgba(0, 0, 0, 0); -webkit-appearance: none; color: #011c28; }
.form-control:focus { color: #011c28; outline: 0; box-shadow: 0 0 0 0.0rem rgb(255, 255, 255); border-color: #c9cdd0; background-color: #f0f4f6; }


.footer { background-color: #08202e; padding-top: 80px; color: #636e74; font-weight: 400; font-size: 17px; }
.footer-line { border-color: #152e3d; }
.footer-widget { padding-bottom: 50px; }
.footer-title { font-size: 24px; font-weight: 600; margin-bottom: 44px; color: #fff; }
.footer-widget ul li a { text-transform: capitalize; font-size: 17px; color: #636e74; display: block; font-weight: 600; }
.footer-widget ul li a:hover { color: #fff; }
.newsletter-form { padding-top: 15px; }
.newsletter-form .form-control { background-color: #1e2e38; border-color: #1e2e38; }
.newsletter-form .form-control:focus { color: #fff; }
.newsletter-form input::-webkit-input-placeholder { color: #fff !important; }
.newsletter-form input:focus::-webkit-input-placeholder { color: #fff !important; }


.tiny-footer { font-size: 14px; padding: 14px 0px; font-weight: 600; background-color: transparent; border-top: 1px solid #152e3d; color: #888d90; line-height: 1; }

</style>
    <!-- footer -->
    <div class="footer">
        <div class="container">
            <div class="row ">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                    <div class="ft-logo"><img src="https://easetemplate.com/free-website-templates/cointrade/images/logo.png" alt=""></div>
                </div>
            </div>
            <hr class="footer-line">
            <div class="row ">
                <!-- footer-about -->
                <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6 col-6 ">
                    <div class="footer-widget ">
                        <div class="footer-title">Company</div>
                        <ul class="list-unstyled">
                            <li><a href="#">About</a></li>
                            <li><a href="#">Support</a></li>
                            <li><a href="#">Press</a></li>
                            <li><a href="#">Legal & Privacy</a></li>
                        </ul>
                    </div>
                </div>
                <!-- /.footer-about -->
                <!-- footer-links -->
                <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6 col-6 ">
                    <div class="footer-widget ">
                        <div class="footer-title">Quick Links</div>
                        <ul class="list-unstyled">
                            <li><a href="#">News</a></li>
                            <li><a href="#">Contact us</a></li>
                            <li><a href="#">FAQ</a></li>
                        </ul>
                    </div>
                </div>
                <!-- /.footer-links -->
                <!-- footer-links -->
                <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6 col-6 ">
                    <div class="footer-widget ">
                        <div class="footer-title">Social</div>
                        <ul class="list-unstyled">
                            <li><a href="#">Twitter</a></li>
                            <li><a href="#">Google +</a></li>
                            <li><a href="#">Linked In</a></li>
                            <li><a href="#">Facebook</a></li>
                        </ul>
                    </div>
                </div>
                <!-- /.footer-links -->
                <!-- footer-links -->
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-6 col-6 ">
                    <div class="footer-widget ">
                        <h3 class="footer-title">Subscribe Newsletter</h3>
                        <form>
                            <div class="newsletter-form">
                                <input class="form-control" placeholder="Enter Your Email address" type="text">
                                <button class="btn btn-default btn-sm" type="submit">Go</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /.footer-links -->
                <!-- tiny-footer -->
            </div>
            <div class="row ">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 text-center ">
                    <div class="tiny-footer">
                        <p>Copyright � All Rights Reserved 2020 | Template Design & Development by <a href="https://easetemplate.com/downloads/bitcoin-cryptocurrency-website-template-amazing-design " target="_blank" class="copyrightlink">EaseTemplate</a></p>
                    </div>
                </div>
                <!-- /. tiny-footer -->
            </div>
        </div>
    </div>