<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	type="text/javascript"></script>
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
	background: -webkit-linear-gradient(left, #6CA6CD, #B0E2FF);
	background: linear-gradient(to right, #B0E2FF, #6CA6CD);
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

.hero-image {
	background-image: url("img/sfondo.jpg");
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
	color: #6CA6CD;
}

footer {
	background-color: #333;
	color: #fff;
	padding: 1rem;
	text-align: center;
}

button {
	border-radius: 4px;
	border: none;
	text-align: center;
	padding: 16px;
	transition: all 0.5s;
	cursor: pointer;
	color: white;
}

button {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

button:after {
	content: '»';
	position: absolute;
	opacity: 0;
	top: 14px;
	right: -20px;
	transition: 0.5s;
}

button:hover {
	padding-right: 24px;
	padding-left: 8px;
}

button:hover:after {
	opacity: 1;
	right: 10px;
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
		<button onclick="auto_scroll('head')">Home</button>
		<button onclick="auto_scroll('anchor1')">Sedi</button>
		<button onclick="auto_scroll('anchor2')">Corsi</button>
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
		<div id="anchor1"></div>
		<div class="feature">
			<div>
				<h3>Sedi</h3>
				<p>L'istituto ha la sede principale a Roma, in via Cantore 55
					tel.06888444</p>
				<br>
				<button id="sedi">Visualizza Sedi</button>
				<br> <br>
				<div id="risp1"></div>
				<div id="err1"></div>
				<br>
			</div>
		</div>
		<div id="anchor2"></div>
		<div class="feature">
			<div>
				<h3>Corsi</h3>
				<p>L'istituto offre i seguenti corsi di formazione:</p>
				<br>
				<button id="corsi">Visualizza Corsi</button>
				<br> <br>
				<div id="risp2"></div>
				<div id="err2"></div>
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

		function auto_scroll(classe) {
			const y = document.getElementById(classe).getBoundingClientRect().top
					+ window.pageYOffset;

			window.scrollTo({
				top : y,
				behavior : 'smooth'
			});
		}
		
		$(function() {
			$('#sedi').click(function() {
				$.ajax({
					url : 'http://localhost:8080/IFP/restapi/sedi',
					success : function(risposte) {
						var html = ""; // Creo una variabile per costruire il contenuto HTML
						risposte.forEach(function(risposta) { // Itero attraverso tutte le risposte
							if (risposta.citta != "Roma")
								html += "<div>"+ risposta.citta+ ": "+ risposta.indirizzo
									+ " tel. "+ risposta.telefono+ "</div>";
						});
						$('#risp1').html(html);
					},
					error : function(error) {
						if (error.status == 404) {
							console.log("Risorsa non trovata: error status = " + error.status);
							$('#err1').html("<div style='color: red'> errore: risorsa non trovata</div>");
						}
					}
				})
			})
			$('#corsi').click(function() {
				$.ajax({
					url : 'http://localhost:8080/IFP/restapi/corsi',
					success : function(risposte) {
						var html = ""; // Creo una variabile per costruire il contenuto HTML
						risposte.forEach(function(risposta) { // Itero attraverso tutte le risposte
							if (risposta.citta != "Roma")
								html += "<div>"+ risposta.nome+ " (durata "+ risposta.durata + " ore) docente "
								+ risposta.docente.nome+ " "+ risposta.docente.cognome+ " titolo di studio: "
								+ risposta.docente.titoloStudio+ "</div>";
						});
						$('#risp2').html(html);
					},
					error : function(error) {
						if (error.status == 404) {
							console.log("Risorsa non trovata: error status = "+ error.status);
							$('#err2').html("<div style='color: red'> errore: risorsa non trovata</div>");
						}
					}
				})
			})
		})
	</script>
</body>
</html>
