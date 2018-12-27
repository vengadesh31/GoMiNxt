<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<style>
        body {
            margin: 0;
            padding: 0;
           background: #e9e9e9;
        }

        a.navbar-brand {
            float: left;
            height: 50px;
            padding: 15px 15px;
            font-size: 18px;
            line-height: 20px;
            text-decoration: none;
            color: orange;<!--orangered-->
            font-family: cursive;
            font-weight: 700;
			

        }

        nav.main-navigation {
            position: relative;
			background-image: url('https://cleancanvas.herokuapp.com/img/backgrounds/color-splash.jpg');
			
        }

        nav.main-navigation ul.nav-list {
            margin: 0;
            padding: 0;
            list-style: none;
            position: relative;
            text-align: right;
        }

        .nav-list li.nav-list-item {
            display: inline-block;
            line-height: 40px;
            margin-left: 30px;
            margin-top: 15px;
        }

        a.nav-link {
            text-decoration: none;
            font-size: 18px;
            font-family: sans-serif;
            font-weight: 500;
            cursor: pointer;
            position: relative;
            color:white;
           
        }

        @keyframes FadeIn {
            0% {
                opacity: 0;
                -webkit-transition-duration: 0.8s;
                transition-duration: 0.8s;
                -webkit-transform: translateY(-10px);
                -ms-transform: translateY(-10px);
                transform: translateY(-10px);
            }


            100% {
                opacity: 1;
                -webkit-transform: translateY(0);
                -ms-transform: translateY(0);
                transform: translateY(0);
                pointer-events: auto;
                transition: cubic-bezier(0.4, 0, 0.2, 1);
            }
        }

        .nav-list li {
            animation: FadeIn 1s cubic-bezier(0.65, 0.05, 0.36, 1);
            animation-fill-mode: both;
        }

        .nav-list li:nth-child(1) {
            animation-delay: .3s;
        }

        .nav-list li:nth-child(2) {
            animation-delay: .6s;
        }

        .nav-list li:nth-child(3) {
            animation-delay: .9s;
        }

        .nav-list li:nth-child(4) {
            animation-delay: 1.2s;
        }

        .nav-list li:nth-child(5) {
            animation-delay: 1.5s;
        }
         .nav-list li:nth-child(6) {
            animation-delay: 1.8s;
        }

        .nav-list li:nth-child(7) {
            animation-delay: 2.1s;
        }
        
        .nav-list li:nth-child(8) {
            animation-delay: 2.4s;
        }

        /* Animation */

        @keyframes fadeInUp {
            from {
                transform: translate3d(0, 40px, 0)
            }

            to {
                transform: translate3d(0, 0, 0);
                opacity: 1
            }
        }

        @-webkit-keyframes fadeInUp {
            from {
                transform: translate3d(0, 40px, 0)
            }

            to {
                transform: translate3d(0, 0, 0);
                opacity: 1
            }
        }

        .animated {
            animation-duration: 1s;
            animation-fill-mode: both;
            -webkit-animation-duration: 1s;
            -webkit-animation-fill-mode: both
        }

        .animatedFadeInUp {
            opacity: 0
        }

        .fadeInUp {
            opacity: 0;
            animation-name: fadeInUp;
            -webkit-animation-name: fadeInUp;
        }
</style>	
 <nav class="main-navigation">
        <div class="navbar-header animated fadeInUp">
            <a class="navbar-brand" rel="home" href="#" 
              title="GoMiNxt">
              <img style="max-width:50px; margin-top: -13px;"
              src="${contextRoot}/resources/images/logo.png">
              </a>      
         </div>
         
   
   <c:choose>
   
   <c:when test="${sessionScope.userlogin==true}">
   
  
         
            <ul class="nav-list">
            <li class="nav-list-item">
                <a href="${contextRoot}/index" class="nav-link"><font color="white">Home</font></a>
            </li>
          
            <li class="nav-list-item">
                <a href="${contextRoot}/aboutus" class="nav-link"><font color="white">About Us</font></a>
            </li>
            <li class="nav-list-item">
                <a href="${contextRoot}/contactus" class="nav-link"><font color="white">Contact Us</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/viewallProduct" class="nav-link"><font color="white">View All Product</font></a>
            </li>
            <li class="nav-list-item">
                <a href="${contextRoot}/cart" class="nav-link"><font color="white">Cart</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/Logout" class="nav-link"><font color="white">Logout</font></a>
            </li>
        </ul>
        </c:when>
        
        
        <c:when test="${sessionScope.userlogin==false}">
   
  
         
            <ul class="nav-list">
            <li class="nav-list-item">
                <a href="${contextRoot}/index" class="nav-link"><font color="white">Home</font></a>
            </li>
            <li class="nav-list-item">
                <a href="${contextRoot}/admin/category" class="nav-link" ><font color="white">category</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/admin/product" class="nav-link"><font color="white">product</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/aboutus" class="nav-link"><font color="white">About Us</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/contactus" class="nav-link"><font color="white">Contact Us</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/Logout" class="nav-link"><font color="white">Logout</font></a>
            </li>
     
        </ul>
        </c:when>
        
        
        <c:otherwise>
     
                 <ul class="nav-list">
            <li class="nav-list-item">
                <a href="${contextRoot}/index" class="nav-link"><font color="white">Home</font></a>
            </li>
            <li class="nav-list-item">
                <a href="${contextRoot}/register1" class="nav-link"><font color="white">Regiser</font></a>
            </li>
            <li class="nav-list-item">
                <a href="${contextRoot}/Login" class="nav-link"><font color="white">Login</font></a>
            </li>
          
            <li class="nav-list-item">
                <a href="${contextRoot}/aboutus" class="nav-link"><font color="white">About Us</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/contactus" class="nav-link"><font color="white">Contact Us</font></a>
            </li>
            
            <li class="nav-list-item">
                <a href="${contextRoot}/viewallProduct" class="nav-link"><font color="white">View All Product</font></a>
            </li>
        </ul>
        </c:otherwise>
        
        </c:choose>
   </div>
   </div>
    </nav>
    
  