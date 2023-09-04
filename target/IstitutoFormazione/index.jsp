<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.betacom.model.Docente"%>
<%@ page import="it.betacom.model.Corso"%>
<%@ page import="it.betacom.model.Sede"%>
<%@ page import="it.betacom.dao.DocenteDao"%>
<%@ page import="it.betacom.dao.CorsoDao"%>
<%@ page import="it.betacom.dao.SedeDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
body {
	font-family: 'Roboto', sans-serif;
	line-height: 1.6;
	margin: 0;
	padding: 0;
	background-color: #f8f8f8;
}

header {
	background: -webkit-linear-gradient(left, #25c481, #25b7c4);
	background: linear-gradient(to right, #25c481, #25b7c4);
	color: #fff;
	padding: 1rem;
	text-align: center;
}

h1 {
	font-size: 30px;
	color: black;
	text-transform: uppercase;
	font-weight: 300;
	text-align: center;
	margin-bottom: 15px;
}
button {
	background-color: #333;
	border: none;
}
nav {
	background-color: #333;
	color: #fff;
	padding: 0.5rem;
	text-align: center;
	width: 100%;
	position: relative;
}

.navbar.fixed {
	position: fixed;
	top: 0px;
}

nav a {
	text-decoration: none;
	color: #fff;
	
	margin: 0 0.5rem;
}

.hero-image {
	background-image:
		url('https://www.lanazione.it/image-service/version/c:YmRlNzBhMjktZGUwZS00:MzYyM2I0/liceo-rossi-si-trasloca-una-sede-provvisoria-per-i-300-studenti-nellex-istituto-vallerga.webp?f=16%3A9&q=1&w=1560');
	height: 350px;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

section {
	max-width: 800px;
	margin: 0 auto;
	padding: 2rem;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.feature {
	display: flex;
	align-items: center;
	margin-top: 2rem;
}

.feature h3 {
	color: #4CAF50;
}

footer {
	background-color: #333;
	color: #fff;
	padding: 1rem;
	text-align: center;
}

@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);

::-webkit-scrollbar {
	width: 6px;
}

::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

::-webkit-scrollbar-thumb {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<header id="head">
		<h1>Istituto Formazione Professionale</h1>
	</header>
	<nav class="navbar">
		<button onclick="auto_scroll('head')"><a>Home</a></button>
		<button onclick="auto_scroll('anchor1')"><a>Sedi</a></button>  
		<button onclick="auto_scroll('anchor2')"><a>Corsi</a></button>
	</nav>
	<div class="hero-image"></div>
	<section>
		<div class="feature">
			<div>
				<h3>Attività  dell'istituto</h3>
				<p>I corsi sono rivolti ai ragazzi in uscita dalla scuola
					secondaria di I grado (scuola media) e sono titolo valido per
					l'assolvimento dell'obbligo di istruzione e del diritto-dovere di
					istruzione e formazione (DDIF) fino a diciotto anni;</p>

				<br>
				<p>Destinati a:</p>
				<br>
				<p>giovani in cerca di prima occupazione</p>

				<p>disoccupati in cerca di nuove opportunità  di lavoro</p>

				<p>lavoratori che intendono migliorare la propria
					professionalità  attraverso percorsi di specializzazione o di
					riqualificazione</p>
			</div>
		</div>
		<div class="feature">
			<div id="anchor1">
				<p>- Sede principale: la nostra sede principale si trova a Roma
					in via Cantore 55. ( bottone o altro elemento per visualizzare la
					lista delle altre sedi con indirizzo e telefono('€˜Visualizza i
					recapiti delle altre sedi'€™)</p>
				<h3 >Sedi</h3>
				<p>L'istituto ha la sede principale a Roma, in via Cantore 55
					tel.06888444</p>
				<p>Milano : via Mazzini 34 tel.024444</p>
				<p>Treviso: via Cavour 67 tel.03466666</p>
				<p>Padova: via Vittorio Emanuele 31 tel.08955555</p>
				<p>Bari: via Firenze 56 tel. 349888</p>
				<p>Torino: via dei Mulini 87 tel.011456666</p>
				<br>
			</div>
		</div>
		<div class="feature">
			<div id="anchor2">
				<p>- Bottone o altro elemento per visualizzare la lista dei
					corsi e relativi docenti('€˜Visualizza lista dei corsi proposti e
					relativi docenti'€™)</p>
				<h3>Corsi</h3>
				<p>L'istituto ha la sede principale a Roma , in via Cantore 55
					tel.06888444</p>
				<p>Milano : via Mazzini 34 tel.024444</p>
				<p>Treviso: via Cavour 67 tel.03466666</p>
				<p>Padova: via Vittorio Emanuele 31 tel.08955555</p>
				<p>Bari: via Firenze 56 tel. 349888</p>
				<p>Torino: via dei Mulini 87 tel.011456666</p>
				<br>
			</div>
		</div>
	</section>

	<footer>
		<p>&copy; @ 2023 Istituto Formazione Professionale di Roma</p>
	</footer>
	
	<script>
		window.addEventListener('scroll', function() {
			var navbar = document.querySelector('.navbar');
			if (window.scrollY > 100)
				navbar.classList.add('fixed')
			else
				navbar.classList.remove('fixed')
		})
		
		function auto_scroll(classe){
			const y = document.getElementById(classe).getBoundingClientRect().top + window.pageYOffset;
			
			window.scrollTo({top: y, behavior: 'smooth'});
		}
	</script>
</body>
</html>
