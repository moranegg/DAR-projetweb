-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 05, 2016 at 04:35 PM
-- Server version: 5.7.16-0ubuntu0.16.04.1
-- PHP Version: 7.0.8-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `musexpress`
--

-- --------------------------------------------------------

--
-- Table structure for table `affluence`
--

CREATE TABLE `affluence` (
  `id_commentaire` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_musee` int(11) NOT NULL,
  `duree` text NOT NULL,
  `text` text NOT NULL,
  `emplacement` text NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Table structure for table `favoris`
--

CREATE TABLE `favoris` (
  `id_user` int(11) NOT NULL,
  `id_musee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `musee`
--

CREATE TABLE `musee` (
  `id` int(11) NOT NULL,
  `nom` text,
  `adresse` text,
  `ville` text,
  `departement` int(11) DEFAULT NULL,
  `codep` int(11) DEFAULT NULL,
  `ferme` text,
  `siteweb` text,
  `fermeture_annuelle` text,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `periode_ouvertue` text,
  `type` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `musee`
--

INSERT INTO `musee` (`id`, `nom`, `adresse`, `ville`, `departement`, `codep`, `ferme`, `siteweb`, `fermeture_annuelle`, `latitude`, `longitude`, `periode_ouvertue`, `type`) VALUES
(1, 'Institut du Monde Arabe', '1, Rue des Fossés Saint-Bernard\nPlace Mohammed V', 'PARIS', 75, 75005, 'NON', 'www.imarabe.org', '1er mai et jours fériés', 48.8489231, 2.35749301052036, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(2, 'Musée de la Chasse et de la Nature', '60, rue des Archives', 'PARIS', 75, 75003, 'NON', 'www.chassenature.org/', 'Jours fériés', 48.8613464, 2.3584276, 'Ouvert du mardi au dimanche de 11h à 18h', 'musée'),
(3, 'Galerie d\'Anatomie Comparée et de Paléontologie (Muséum d\'Histoire Naturelle)', 'Jardin des Plantes\n2, rue Buffon', 'PARIS', 75, 75005, 'NON', 'www.mnhn.fr', '1er mai', 48.8432434, 2.35954535401297, 'Ouvert du mercredi au lundi de 10h à 17h', 'musée'),
(4, 'Galerie d’entomologie (Muséum national d\'histoire naturelle)', '57, Rue Cuvier', 'PARIS', 75, 75005, 'OUI', 'www.mnhn.fr', '', 48.8443464, 2.3562118, '', 'musée'),
(5, 'Musée Hébert', 'Hôtel de Montmorency-Bours\n85, Rue du Cherche Midi', 'PARIS', 75, 75006, 'OUI', '', '', 48.8474495, 2.3227049, '', 'musée'),
(6, 'Musée Zadkine', '100 bis, rue d\'Assas', 'PARIS', 75, 75006, 'NON', 'www.zadkine.paris.fr', 'Jours fériés', 48.8443793, 2.3328737, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(7, 'Etablissement Public du Musée d\'Orsay', '62, Rue de Lille', 'PARIS', 75, 75007, 'NON', 'www.musee-orsay.fr', 'Jours fériés', 48.8597437, 2.3259203, 'Ouvert le mardi, mercredi, vendredi au dimanche de 9h30 à 18h, le jeudi de 9h30 à 21h45', 'musée'),
(8, 'Musée National Auguste Rodin', 'Hôtel Biron\n77, rue de Varenne', 'PARIS', 75, 75007, 'NON', 'www.musee-rodin.fr', '1er janvier, 1er mai, 25 décembre', 48.8513447, 2.3272485, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(9, 'Musée National de la Légion d\'Honneur et des Ordres de Chevalerie', '2, Rue de la Légion d\'Honneur', 'PARIS', 75, 75007, 'NON', 'www.musee-legiondhonneur.fr', '1er janvier, 1er mai, 15 août, 1er novembre et 25 décembre', 48.860275, 2.3247399, 'Ouvert du mercredi au dimanche de 13h à 18h. Accessible le mardi pour les groupes sur réservation', 'musée'),
(10, 'Musée Lénine', '4 rue Marie-Rose', 'PARIS', 75, 75014, 'OUI', '', '', 48.8263909, 2.3306427, 'Entrée sur rdv uniquement', 'musée'),
(11, 'Musée Jean-Jacques Henner', '43, Avenue de Villiers', 'PARIS', 75, 75017, 'NON', 'www.musee-henner.fr ou www.henner-intime.fr', '1er janvier, 1er mai, dimanche et lundi de Pentecôte, 14 juillet, 15 août, Noël', 48.883052, 2.3077052, 'Ouvert de 11h-18h du mercredi au lundi. Nocturne jusqu’à 21h le premier jeudi du mois', 'musée'),
(12, 'Musée de la Musique', '221, Avenue Jean-Jaurès', 'PARIS', 75, 75019, 'NON', 'www.cite-musique.fr', '', 48.9009201, 2.3885538, 'Ouvert du mardi au samedi de 12h à 18h, dimanche de 10h à 18h. Nocturne expositions temporaires le vendredi', 'musée'),
(13, 'Musée d\'Art Moderne de la ville de Paris', '11, Avenue du Pdt Wilson', 'PARIS', 75, 75116, 'NON', 'www.mam.paris.fr', '', 48.8638282, 2.2908297, 'Ouvert du mardi au dimanche de 10 à 18 h. Nocturne le mercredi jusqu\'a 22h pour les expositions temporaires', 'musée'),
(14, 'Musée National de la Marine', '17, Place du Trocadéro', 'PARIS', 75, 75116, 'NON', 'www.musee-marine.fr', '1er janvier, 1er mai, 25 décembre', 48.8618163, 2.2873421, 'Ouvert du mercredi au lundi de 10h à 18h', 'musée'),
(15, 'Musée du Service de Santé des Armées du Val-de-Grâce', '1, Place Alphonse Laveran', 'PARIS Cedex 05', 75, 75230, 'NON', 'www.valdegrace.org', '', 48.8405539, 2.340908, 'Ouvert de mardi au jeudi et samedi, dimanche de 12 h à 18 h', 'musée'),
(16, 'Château-musée de Nemours', 'Rue Gautier 1er', 'NEMOURS', 77, 77140, 'NON', 'Site de la ville - www.ville-nemours.fr', '1er mai, 25 décembre, 1er janvier', 48.2655865, 2.6970907, 'Ouvert du mercredi au samedi de 10h à 12h30 et de 14h à 18h, dimanche de 14h à 18h. Mardi réservé aux groupes et aux scolaires', 'musée'),
(17, 'Musée du Château de Fontainebleau', 'Château de Fontainebleau', 'FONTAINEBLEAU', 77, 77300, 'NON', 'www.châteaudefontainebleau.fr', '1er janvier, 1er mai, 25 décembre', 48.40237815, 2.70070078865486, 'Ouvert de 9h30 à 17h d\'octobre à mars et de 9h30 à 18h d\'avril à septembre', 'musée'),
(18, 'Etablissement Public du Musée et du Domaine National de Versailles', 'R.P. 834', 'VERSAILLES Cedex', 78, 78008, 'NON', 'www.chateauversailles.fr', 'Certains jours fériés', 48.80486, 2.12104082373271, 'Ouvert du 1er novembre au 31 mars du mardi au dimanche de 9h à 17h30 et du 1er avril au 31 octobre de 9h à18h30', 'musée'),
(19, 'Musée Départemental Maurice Denis', '2 bis, Rue Maurice Denis\nB.P. 60222', 'SAINT-GERMAIN-EN-LAYE Cedex', 78, 78102, 'NON', 'www.musee-mauricedenis.fr', '1er janvier, 1er mai et 25 décembre et lundi fériés', 48.8918161, 2.0876811, 'Ouvert du mardi au vendredi de 10h à 17h30 et samedi et dimanche de 10h à 18h30', 'musée'),
(20, 'Musée Rambolitrain', '4, Place Jeanne d\'Arc', 'RAMBOUILLET', 78, 78120, 'NON', 'www.rambolitrain.com', '25 décembre et 1er janvier', 48.6471298, 1.8234529, 'Ouvert du mercredi au dimanche et jours fériés de 10h à 12h et de 14h à 17h30', 'musée'),
(21, 'Musée de la Toile de Jouy', 'Château de l\'Eglantine\n54, rue Charles de Gaulle', 'JOUY-EN-JOSAS', 78, 78350, 'NON', 'www.museedelatoiledejouy.fr', '25 décembre, 1er janvier', 48.7690689, 2.151438600000006, 'Ouvert du mardi au dimanche de 11h à 18h', 'musée'),
(22, 'Musée-Promenade de Marly-Le Roi /Louveciennes', 'La Grille Royale Parc de Marly', 'LOUVECIENNES', 78, 78430, 'NON', 'www.musee-promenade.fr', '', 48.868389, 2.097727, 'Ouvert du mercredi au dimanche de 14h à 17h30 d\'octobre à mars et de 14h à 18h30 d\'avril à septembre. Pour les scolaires du lundi au vendredi de 9h à12h30 et de 13h30 à 17h. Pour les groupes adultes du mardi au vendredi de 9h à 12h et mardi au dimanche de', 'musée'),
(23, 'Musée Intercommunal d\'Etampes', 'Mairie d\'Etampes\nB.P. 109', 'ETAMPES Cedex', 91, 91152, 'NON', 'site de la ville', 'Jours fériés', 48.52905205, 2.01553075934258, 'Ouvert du mercredi au dimanche de 14h à 17h', 'musée'),
(24, 'Musée Dunoyer de Segonzac', '5, Place des Droits de l\'Homme', 'BOUSSY-SAINT-ANTOINE', 91, 91800, 'NON', '', '', 48.6889562, 2.5297921999999744, '', 'musée'),
(25, 'Musée d\'Art et d\'Histoire', '11, Rue des Pierres', 'MEUDON', 92, 92190, 'TRAVAUX', 'www.ville-meudon.fr/meudon/culture-et-patrimoine/copy5_of_structures-culturelles', 'Août', 48.806307, 2.23476536869386, 'Ouvert du mercredi au dimanche de 14h à 18h. Pour les groupes et centre de documentation ouvert du lundi au dimanche de 9h à 12h et de 14h à 18h', 'musée'),
(26, 'Musée Municipal de Saint-Cloud', '"Jardin des Avelines"\n60, Rue Gounod', 'SAINT-CLOUD', 92, 92210, 'NON', 'www.ville-saint-cloud.fr/temps_libre/musee.htm', 'Août', 48.885504, 2.177644, 'Ouvert du mercredi au vendredi de 12h à 18h et la samedi et dimanche de 14h à 18h', 'musée'),
(27, 'Musée Municipal d\'Art et d\'Histoire', '2, Rue Gabriel Péri', 'COLOMBES', 92, 92700, 'NON', 'Site de la ville - www.mairie-colombes.fr', 'Aoüt et 1 semaine durant les vacances de Noël', 48.9230614, 2.2504187, 'Ouvert du mercredi au samedi de 14h à 18h', 'musée'),
(28, 'Musée de l\'Histoire Vivante', '31, Boulevard Théophile Sueur', 'MONTREUIL-SOUS-BOIS', 93, 93100, 'NON', 'www.museehistoirevivante.com', '', 48.8652058, 2.4684716, 'Ouvert du mercredi au vendredi de 14h à 17, le week-end de 14h à 18h', 'musée'),
(29, 'Musée Municipal', '12, Rue Albert Dhalenne', 'SAINT-OUEN', 93, 93400, 'NON', '', '', 0, 0, '', 'musée'),
(30, 'Musée de Saint-Maur - Villa Médicis', '5, Rue Saint-Hilaire', 'LA VARENNE-SAINT-HILAIRE', 94, 94210, 'NON', 'www.saint-maur.com/musee/musee.htm', 'Fermé du 31 juillet au 16 août 2010', 48.7929217, 2.51447702415525, 'Ouvert du mardi au samedi de 10h à 12h et de 14h à 18h, le dimanche de 11h à 13h et de 14h à 19h', 'musée'),
(31, 'Musée Archéologique du Val d\'Oise', 'Place du Château', 'GUIRY-EN-VEXIN', 95, 95450, 'NON', 'www.valdoise.fr/content/content15651.html', '25 décembre et 1er janvier', 49.1089657, 1.8496944, 'Ouvert de 9h à12h et de 13h30 à 17h30, week-end et jours fériés de 13h30 à 18h30 du 15 octobre au 14 mars et de 10h à 12h et de 14h à 19h du 15 mars au 14 octobre', 'musée'),
(32, 'Musée Cognacq-Jay, Musée du XVIIIe siècle de la ville de Paris', '8, Rue Elzévir', 'PARIS', 75, 75003, 'NON', 'www.cognacq-jay.paris.fr', 'Certains jours fériés', 48.8582094, 2.3614604, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(33, 'Musée d\'Art et d\'Histoire du Judaïsme', 'Hôtel de Saint-Aignan\n71, Rue du Temple', 'PARIS', 75, 75003, 'NON', 'www.mahj.org', '1er janvier, 1er mai, Roch Hachana, Yom Kippour', 48.8612342, 2.35550151105171, 'Ouvert du lundi au vendredi de 11h à 18h et le dimanche de 10h à 18h. Nocturne jusqu\'à 21h lors des expositions temporaires', 'musée'),
(34, 'Musée National Picasso', 'Hôtel Salé\n5, Rue de Thorigny', 'PARIS', 75, 75003, 'TRAVAUX', 'www.musee-picasso.fr', '1er janvier et 25 décembre', 48.8566486, 2.3558134, 'Ouvert de 9h30 à 18h d\'avril à septembre et de 9h30 à 17h30 d\'octobre à mars', 'musée'),
(35, 'Maison de Victor Hugo', '6, Place des Vosges', 'PARIS', 75, 75004, 'NON', 'www.musee-hugo.paris.fr', '', 48.854871, 2.3661025, 'Ouvert de 10h à 18h du mardi au dimanche', 'musée'),
(36, 'Galerie de Minéralogie et de Géologie (Muséum d\'Histoire Naturelle)', 'Jardin des Plantes\n36, Rue Geoffroy Saint-Hilaire', 'PARIS', 75, 75005, 'TRAVAUX', 'www.mnhn.fr', '1er mai', 48.8432434, 2.35954535401297, 'Ouvert du mercredi au lundi de 10h à 17h', 'musée'),
(37, 'Musée National du Moyen Age-Thermes de Cluny', '6, Place Paul Painlevé', 'PARIS', 75, 75005, 'NON', 'www.musee-moyenage.fr', '1er janvier, 1er mai et 25 décembre', 48.850322, 2.3439302, 'Ouvert du mercredi au lundi de 9h15 à 17h45', 'musée'),
(38, 'Musée Cernuschi, Musée des Arts de l\'Asie de la ville de Paris', '7, Avenue Velasquez', 'PARIS', 75, 75008, 'NON', 'www.cernuschi.paris.fr', '', 48.8796408, 2.3124486, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(39, 'Musée de la Franc-Maçonnerie', '16, Rue Cadet', 'PARIS', 75, 75009, 'NON', 'www.museefm.org', 'Jours fériés', 48.8748405, 2.34301, 'Ouvert du mardi au samedi de 14h à 18h', 'musée'),
(40, 'Cité Nationale de l\'Histoire et des Cultures de l\'Immigration', 'Palais de la Porte Dorée\n293, avenue Daumesnil', 'PARIS', 75, 75012, 'NON', 'www.histoire-immigration.fr', '25 décembre ,  1er janvier, 24 mars, 1er mai, 12 mai et 14 juillet 2008', 48.83527605, 2.40936723102986, 'Ouvert du mardi au vendredi de 10h à 17h30 et le samedi et dimanche de 10h à 19h', 'musée'),
(41, 'Musée National du Sport', '93, avenue de France', 'PARIS', 75, 75013, 'NON', 'www.museedusport.fr', '1er janvier, 15 août, 25 décembre', 48.8291911, 2.3776989, 'Ouvert du mardi au vendredi de 10h à 18h et le samedi et premier dimanche du mois et jours fériés de 14h à 18h', 'musée'),
(42, 'Maison de Balzac', '47, rue Raynouard', 'PARIS', 75, 75016, 'NON', 'www.balzac.paris.fr', 'Jours fériés', 48.8553621, 2.2808368, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(43, 'Musée d\'Ennery', '59, Avenue Foch', 'PARIS', 75, 75116, 'OUI', '', '', 48.8716939, 2.2814079, '', 'musée'),
(44, 'Musée de Melun', '5, Rue du Franc Mûrier', 'MELUN Cedex', 77, 77008, 'NON', 'Site de la ville : www.ville-melun.fr', '20 décembre au 4 janvier 2008 - jours fériés', 48.5362489, 2.659311, 'Ouvert du mercredi au dimanche de 14h à 18h', 'musée'),
(45, 'Musée Départemental de Préhistoire d\'Île de France', '48, Avenue Etienne Dailly', 'NEMOURS', 77, 77140, 'NON', 'www.weine-et-marne.fr (rubrique "loisirs/musées départementaux)', '1er janvier, 1er mai, 25 décembre', 48.2602285, 2.7136181, 'Ouvert de jeudi à mardi 10h à 12h30 et de 14h à 17h30 de septembre à juin et de 10h à 12h30 et de 14h à 18h en juillet et août', 'musée'),
(46, 'Musée d\'Art et d\'Histoire Militaire', '88, Rue St-Honoré', 'FONTAINEBLEAU', 77, 77300, 'NON', '', '', 48.4043599, 2.6953723, 'Ouvert du mardi au samedi de 14h à 17h30 et le matin de 10h à 12h sur rendez-vous', 'musée'),
(47, 'Musée Gatien Bonnet', '8, Cour Pierre Herbin', 'LAGNY-SUR-MARNE', 77, 77405, 'NON', 'Site de la ville', 'Jours fériés', 48.879847, 2.7077716, 'Ouvert du mercredi au dimanche de 14h à 18h', 'musée'),
(48, 'Maison Natale de Louis Braille', '13, Rue Louis-Braille', 'COUPVRAY', 77, 77700, 'NON', 'www.braillenet.org/louis_braille/maisnat.htm', '', 48.89452559999999, 2.792211199999997, 'Ouvert en visites guidées d\'avril à septembre du mardi au dimanche (10h, 11h, 14h, 15h, 16h et 17h) et d\'octobre à mars du mardi au dimanche (14h, 15h et 16h) groupe sur réservation uniquement le vendredi (octobre à mars). Ouvert de 10h à 12h pour les éco', 'musée'),
(49, 'Musée de Port Royal des Champs', 'Route des Granges', 'MAGNY-LES-HAMEAUX', 78, 78114, 'NON', 'www.musee-portroyal.fr ou www.port-royal-des-champs.eu', '', 48.747975, 2.017399, 'Ouvert du 1er novembre au 31 mars le lundi du mercredi au vendredi de 10h à 12h et de 14h à 17h30, samedi et dimanche de 14h à 18h et du 1er avril au 31 octobre de 10h30 à 12h30 et de 14h à 18h samedi et dimanche de 10h30 à 18h30', 'musée'),
(50, 'Musée-Maison Maurice Ravel', '5, Rue Maurice Ravel', 'MONTFORT-L\'AMAURY', 78, 78490, 'NON', 'www.ville-montfort-l-amaury.fr', '', 48.776495, 1.8028643, 'Ouvert depuis 2010, uniquement les week-end de 10h à 11h, 14h30 à 16h30. Pour les groupes sur rendez-vous mercredi au vendredi', 'musée'),
(51, 'Musée Municipal Robert Dubois-Corneau', '16, Rue du Réveillon', 'BRUNOY', 91, 91800, 'NON', 'www.brunoy.fr', 'Août  et jours fériés et du 25 décembre 2010 au 4 janvier 2011', 48.706927, 2.4999615, 'Ouvert du mercredi au dimanche de 14h à 18h du 1er mai au 31 octobre et de 14h à 17h du 1er novembre au 30 avril. Pour les scolaire ouvert du mercredi au vendredi de 9h à 12h et de 14h à 17h', 'musée'),
(52, 'Musée-Jardin Paul Landowski', '14, Rue Max Blondat', 'BOULOGNE-BILLANCOURT', 92, 92100, 'NON', '', '', 48.8449115, 2.2471369, '', 'musée'),
(53, 'Musée des Châteaux de la Malmaison et Bois-Préau', 'Avenue du Château de Malmaison', 'RUEIL-MALMAISON', 92, 92500, 'NON', 'www.chateau-malmaison.fr', '25 décembre, 1er janvier', 48.8733692, 2.1689624, 'Ouvert du mercredi au lundi du 1er octobre au 31 mars de 10h à 12h30 et de 13h30 à 17h15, week-end 17h45, du 1er avril au 30 septembre de 10h à 12h30 et de 13h30 à 17h45, week-end 18h15. Ouverture du parc du 1er octobre au 31 mars de 10h à 18h et du 1er a', 'musée'),
(54, 'Musée Municipal', 'Avenue du Consul Général Nordling', 'LIVRY-GARGAN', 93, 93190, 'NON', 'www.mairie-livrygargan.fr/rubrique culture loisirs', '25 décembre et 1er mai et août', 48.9174414, 2.5337832, 'Ouvert du mercredi au dimanche de 14h à 17h ou de 14h à 18h selon les saisons', 'musée'),
(55, 'Musée d\'Art et d\'Histoire', '22 bis, rue Gabriel Péri', 'SAINT-DENIS', 93, 93200, 'NON', 'www.musee-saint-denis.fr', 'Jours fériés', 48.9407059, 2.3565817, 'Ouvert lundi, mercredi, vendredi de 10h à 17h30, le jeudi de 10h à 20h, le week-end de 14h à 18h30', 'musée'),
(56, 'Musée Emile Jean', '31, rue Louis-Lenoir', 'VILLIERS-SUR-MARNE', 94, 94350, 'NON', 'www.mairie-villiers94.com/francais/vie_quoti/vie_quot_culture7.php', '', 48.82665745, 2.54279433311837, 'Ouvert chaque samedi de 14 h 30 à 17 h 30. Visites de groupes et scolaires, sur réservation, du lundi au vendredi', 'musée'),
(57, 'Musée de la Résistance Nationale', 'Parc Vercors\n88, Avenue Marx Dormoy - B.P. 135\nB.P. 135', 'CHAMPIGNY-SUR-MARNE Cedex', 94, 94501, 'NON', 'www.musee-resistance.com', 'Septembre, 1er janvier, lundi de Pâques, 1er mai, lundi de Pentecôtes, Ascension, 14 juillet, Assomption, 15 août, 1er novembre, 25 décembre', 48.81060105, 2.52229984855269, 'Ouvert du mardi au vendredi de 9h à 12h30 et de 14h à 17h30. Samedi et Dimanche de 14h à 18h, le 8 mai', 'musée'),
(58, 'Musée Camille Pissarro', '17, Rue du Château', 'PONTOISE', 95, 95300, 'NON', 'www.ville-pontoise.fr', 'Jourqs fériés', 49.0483893, 2.099896, 'Ouvert du mercredi au dimanche de 14h à 18h', 'musée'),
(59, 'Musée Tavet Delacour', '4, Rue Lemercier', 'PONTOISE', 95, 95300, 'NON', 'Site de la ville - www.ville-Pontoise.fr', 'Jours fériés', 49.0510006, 2.0998623, 'Ouvert du mercredi au dimanche de 10h à 12h30 et de 13h30 à 18h', 'musée'),
(60, 'Musées Arts Décoratifs  Mode et du Textile', '107, Rue de Rivoli', 'PARIS', 75, 75001, 'NON', 'www.lesartsdecoratifs.fr', '', 48.8638473, 2.3317955, 'Ouvert du mardi au vendredi de 11h à 18h, samedi et dimanche de 10h à 18h, nocturnele jeudi jusqu\'à 21h', 'musée'),
(61, 'Musée de l\'Armée', 'Hôtel National des Invalides\n129, rue de Grenelle', 'PARIS', 75, 75007, 'NON', 'www.invalides.org', '1er janvier, 1er mai, 1er novembre, 25 décembre', 48.8560795, 2.3115715, 'Ouvert d\'avril à septembre de 10h à 18h (18h30 le dimanche), d\'octobre à mars de 10h à 17h (17h30 le dimanche). Du 15 juin au 15 septembre l\'église du dôme reste ouverte jusqu\'à 19h', 'musée'),
(62, 'Musée Nissim de Camondo (Les Arts Décoratifs)', '63, Rue de Monceau', 'PARIS', 75, 75008, 'NON', 'www.lesartsdecoratifs.fr/', '1er janvier, 1er mai, 15 août et 25 décembre', 48.8787605, 2.3126925, 'Ouvert du mercredi au dimanche de 10h à 17h30', 'musée'),
(63, 'Petit Palais, Musée des Beaux-Arts de la ville de Paris', 'Avenue Winston-Churchill', 'PARIS', 75, 75008, 'NON', 'www.petitpalais.paris.fr', '', 48.8675162, 2.3139892, 'Ouvert tous les jours de 10h à 18h', 'musée'),
(64, 'Mémorial du Maréchal Leclerc de Hauteclocque et de la Libération de Paris - Musée Jean Moulin', '23, Allée de la 2ème DB', 'PARIS', 75, 75015, 'NON', 'www.ml-leclerc-moulin.paris.fr', '', 48.8391054, 2.3179996, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(65, 'Etablissement Public du Musée des Arts Asiatiques Guimet', '6, Place d\'Iéna', 'PARIS', 75, 75116, 'NON', 'www.museeguimet.fr', '1er janvier, 1er mai, 25 décembre', 48.8650504, 2.2936808, 'Ouvert du mercredi au lundi de 10h à 18h', 'musée'),
(66, 'Musée Galliéra - Musée de la Mode de la ville de Paris', '10, Avenue Pierre 1er de Serbie', 'PARIS', 75, 75116, 'TRAVAUX', 'www.galliera.paris.fr', 'Musée fermé en dehors des expositions temporaires. Certains jours fériés', 48.8658717, 2.2963515, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(67, 'Musée de la Grande Guerre', 'Hôtel de Ville\nBP 227', 'MEAUX Cedex', 77, 77107, 'PREFIGURATION', 'http://www.paysdemeaux.com/index.php?Message=CAPM_GP_musee', '', 48.9281742, 2.89633080839536, '', 'musée'),
(68, 'Ecomusée', 'Ferme de CouleOUIn\nPlace Georges Henri Rivière', 'SAVIGNY-LE-TEMPLE', 77, 77176, 'NON', 'Site de la ville www.savigny-le-temple.fr', '25 décembre, 1er janvier, 1er novembre et 1er mai', 48.57413, 2.5826, 'Ouvert du mercredi au vendredi de 14h à 17h, le samedi et dimanche de 15h à 18h. Sur réservation de 10h à 12h', 'musée'),
(69, 'Musée Municipal de Chelles Alfred Bonno', 'Place de la République', 'CHELLES', 77, 77500, 'NON', '', 'Vacances scolaires de fin d\'année et août', 48.8778243, 2.5914673, 'Ouvert le mercredi de 10h à 12h et de 14h à 18h, le dimanche de 14h à 17h, lundi, mardi, jeudi et vendredi sur réservation pour les groupes', 'musée'),
(70, 'Musée Municipal des Capucins', 'Hôtel de Ville\nB.P. 171', 'COULOMMIERS cedex', 77, 77527, 'NON', 'www.tourisme77.fr ou www.coulommiers.fr', '', 48.7626577, 3.0866676, 'Ouvert de mai à septembre le mercredi, vendredi, samedi, dimanche de 14h à 18h, d\'octobre à avril le mercredi, samedi et dimanche de 14h à 17h30', 'musée'),
(71, 'Musée Municipal', '', 'CRECY-LA-CHAPELLE', 77, 77580, 'OUI', '', '', 48.855313, 2.9338418, '', 'musée'),
(72, 'Musée des Pays de Seine-et-Marne', '17, Avenue de la Ferté-Sous-Jouarre', 'SAINT-CYR-SUR-MORIN', 77, 77750, 'NON', 'Site du conseil général - www.seine-et-marne.fr - rubrique "loisirs"', '24 décembre au 1er janvier et 1er mai', 48.907911, 3.1821310000000267, 'Ouvert du dimanche au vendredi de septembre à juin de 10h à 12h30 et de 14h à 17h30 - En juillet et août de 10h à 12h30 et de 14h à 18h30', 'musée'),
(73, 'Musée du Jouet Pierre Pinel', '1, Enclos de l\'Abbaye', 'POISSY', 78, 78300, 'NON', 'site de la ville', 'Jours fériés', 48.9279015, 2.0363906, 'Ouvert du mardi au dimanche de 9h30 à 12h et de 14h à 17h30', 'musée'),
(74, 'Musée Victor Aubert', '24, rue Quincampoix', 'MAULE', 78, 78580, 'NON', 'http://museeaubertmaule.free.fr', '', 48.9082945, 1.84886, 'Ouvert chaque mercredi et dimanche du mois de 15h à 18h', 'musée'),
(75, 'Musée de la Batellerie', 'Château du Prieuré\n3, Place Gévelot', 'CONFLANS-SAINTE-HONORINE', 78, 78700, 'NON', 'www.mairie-conflans-sainte-honorine.fr', '', 48.99249445, 2.09571707394768, 'Ouvert du lundi au vendredi de 9h à 12h et de 13h30 à 18h, mardi de 13h30 à 18h, samedi dimanche et jours fériés de 14h à 17h en hiver et de 15h à 18h en été', 'musée'),
(76, 'Musée des Années Trente', 'Espace Landowski\n28, avenue André Morizet', 'BOULOGNE-BILLANCOURT', 92, 92100, 'NON', 'Site de l\'association des amis -  www.annees30.com/', 'Du 1er au 18 août inclus et jours fériés', 48.8361987, 2.23928431830969, 'Ouvert du mardi au dimanche de 11h à 18h', 'musée'),
(77, 'Musée Français de la Carte à Jouer', '16, Rue Auguste Gervais', 'ISSY-LES-MOULINEAUX', 92, 92130, 'NON', 'www.issy.com/musee', 'Jours fériés', 48.8221995, 2.2735085, 'Ouvert le mercredi, samedi et dimanche de  11h à 18h, jeudi de 14h à 20h, vendredi de 14h à 18h, juillet-août du mercredi au dimanche de 13h à 18h. Groupes sur rendez-vous du mardi au vendredi', 'musée'),
(78, 'Musée - Atelier Rodin', '19, Avenue Auguste Rodin', 'MEUDON', 92, 92190, 'NON', 'www.musee-rodin.fr', '', 48.8136386, 2.2523592, 'Ouvert du 1er week-end d\'avril au dernier week-end de septembre, les vendredis, samedis et dimanches de 13h à 18h', 'musée'),
(79, 'Musée des Automates', 'Hôtel Arturo Lopez\n12, Rue du Centre', 'NEUILLY-SUR-SEINE', 92, 92200, 'OUI', '', '25 décembre, 1er janvier', 48.87976035, 2.25300238286983, 'Musée en travaux ouvert 6 jours en 2010', 'musée'),
(80, 'Musée de l\'Île de France', '', 'SCEAUX', 92, 92330, 'NON', 'www.chateau-sceaux.fr ou/www.domaine-de-sceaux.fr (site du conseil général) ou www.sceaux.fr', 'Certains jours fériés', 48.7743723, 2.30006741975085, 'Ouvert du mercredi au lundi d\'avril à octobre de 10h à 13h et 14h à 18h (18h30 le dimanche) de novembre à mars de 10h à 13h et de 14h à 17h. Ouverture en continu le week-end toute l\'année', 'musée'),
(81, 'Ecomusée du Val de Bièvre', 'Ferme de Cottinville\n41, rue Maurice Ténine', 'FRESNES', 94, 94260, 'NON', 'www.agglo-valdebievre.fr', '', 48.754203, 2.323804, 'Ouvert mercredi, samedi de 10h à 12h et de 14h à 18h, mardi, jeudi, vendredi et dimanche de 14h à 18h', 'musée'),
(82, 'Musée Fragonard', 'Ecole Nationale Vétérinaire d\'Alfort\n7, Avenue du Gal de Gaulle', 'MAISONS-ALFORT Cedex', 94, 94704, 'NON', 'www.musee.vet-alfort.fr', '', 48.814745, 2.42204, 'Ouvert le mercredi et le jeudi de 14h à 18h, le week-end de 13h à 18h', 'musée'),
(83, 'Musée jean-Jacques Rousseau', '5, Rue Jean-Jacques Rousseau', 'MONTMORENCY', 95, 95160, 'NON', '/www.ville-montmorency.fr', '1er mai et fêtes de fin d’année', 48.9870929, 2.3215689, 'Ouvert du mardi au dimanche de 14h à 18h et pour les groupes du mardi au samedi de 9h30 à 13h', 'musée'),
(84, 'Musée du Louvre', '34, Quai du Louvre', 'PARIS', 75, 75001, 'NON', 'www.louvre.fr', 'le 1er janvier, le 1er mai, le 8 mai et le 25 décembre 2007', 48.86147675, 2.337115372454, 'Ouvert lundi, jeudi, samedi et dimanche de  9h à 18h, mercredi et vendredi de 9h à 22h. Le hall Napoléon est ouvert de 9h à 22h', 'musée'),
(85, 'Musée National de L\'Orangerie des Tuileries', 'Jardin des Tuileries', 'PARIS', 75, 75001, 'NON', 'www.musee-orangerie.fr', '1er mai et 25 décembre', 48.86376555, 2.3226600557807, 'Ouvert du mercredi au lundi de 9h à 18h', 'musée'),
(86, 'Musée de la Vie Romantique', '16, Rue Chaptal', 'PARIS', 75, 75009, 'NON', 'http://www.paris.fr/portail/Culture/Portal.lut?page_id=5851', '', 48.8808923, 2.3332855, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(87, 'Musée Nationale Gustave Moreau', '14, Rue de la Rochefoucauld', 'PARIS', 75, 75009, 'NON', 'www.musee-moreau.fr', '1er janvier, 1er mai, 25 décembre', 48.8779149, 2.3344031, 'Ouvert du mercredi au lundi de 10h à 12h45 et de 14h à 17h15', 'musée'),
(88, 'Aquarium Tropical', '293, avenue Daumesnil', 'PARIS', 75, 75012, 'NON', 'www.aquarium-portedoree.fr', '', 48.8346407, 2.4095903, 'Ouvert tous les jours du mardi au vendredi de 10h à 17h15, le week-end de 10h à 19h, y compris certains jours fériés', 'musée'),
(89, 'Les Catacombes', '1, avenue du Colonel Henri Rol-Tanguy\n(place Denfert-Rochereau)', 'PARIS', 75, 75014, 'NON', 'www.catacombes-de-paris.fr', 'Jours fériés, dimanche de Pâques et de Pentecôtes', 48.83383915, 2.33240808278196, 'Ouvert du mardi au dimanche de 10h à 17h', 'musée'),
(90, 'Musée Bourdelle', '16, Rue Antoine Bourdelle', 'PARIS', 75, 75015, 'NON', 'www.bourdelle.paris.fr', '', 48.8430139, 2.3188646, 'Du mardi au dimanche de 10h à 18h', 'musée'),
(91, 'Musée Bouchard', '25, Rue de l\'Yvette', 'PARIS', 75, 75016, 'OUI', 'www.musee-bouchard.com', '', 48.853546, 2.2659185, '', 'musée'),
(92, 'Musée de l\'Homme (Muséum National d\'Histoire Naturelle)', 'Place du Trocadéro', 'PARIS', 75, 75116, 'TRAVAUX', 'www.mnhn.fr', '', 48.86134405, 2.2869583497739, 'Ouvert du mercredi au lundi de 10h à 17h, le week-end de 10h à 18h', 'musée'),
(93, 'Musée National des Techniques (Conservatoire National des Arts et Métiers)', '292, rue Saint-Martin', 'PARIS cedex 03', 75, 75141, 'NON', 'www.arts-et-metiers.net', '1er mai, 25 décembre', 48.8660977, 2.3554138, 'Ouvert du mardi au dimanche de 10 h à 18h, jeudi jusqu\'à 21h30', 'musée'),
(94, 'Musée National d\'Art Moderne (Centre National d\'Art et de Culture Georges Pompidou)', 'Place Georges Pompidou', 'PARIS Cedex 04', 75, 75191, 'NON', 'www.centrepompidou.fr', '1er mai', 48.8607161, 2.3525007, 'Ouvert du mercredi au lundi de 11h à 21h (musée et expositions)', 'musée'),
(95, 'Musée du Quai Branly', '222, rue de l\'Université', 'PARIS cedex 07', 75, 75343, 'NON', 'www.quaibranly.fr', '1er mai', 48.8602251, 2.2973673, 'Mardi, mercredi, dimanche de 11h à 19h - jeudi, vendredi, samedi de 11h à 21h. Groupes tous les matin de 9h30 à 11h sauf le dimanche. Ouverture exceptionnelle les lundis de 11h à 19h pendant les vacances de Pâques', 'musée'),
(96, 'Musée de la Poste', '34, Boulevard de Vaugirard', 'PARIS Cedex 15', 75, 75731, 'NON', 'www.museedelaposte.fr ou www.laposte.fr/musee', 'Jours fériés', 48.841345, 2.3172728, 'Ouvert du lundi au samedi de 10h à 18h', 'musée'),
(97, 'Musée de la Gendarmerie', 'Ecole des Officiers de la Gendarmerie Nationale\n8, rue Emile Leclerc', 'MELUN', 77, 77017, 'NON', 'www.servicehistorique.sga.defense.gouv.fr', 'Jours fériés', 48.5451563, 2.6540764, 'Ouvert du lundi au vendredi de 8h à 12h et de 14h à 18h', 'musée'),
(98, 'Musée Bossuet', '5, Place Charles de Gaulle', 'MEAUX', 77, 77100, 'NON', 'site de la ville - www.ville-meaux.fr', '1er Janvier, 1er Mai, 14 Juillet et 25 Décembre', 48.96133415, 2.87840344133292, 'Ouvert du 1er avril au 30 septembre de 10h à 12h et de 14h à18h, du 1er octobre au 31 mars de 10h à 12h et de 14h à 17h', 'musée'),
(99, 'Musée de Provins et du Provinois', '7, rue du Palais', 'PROVINS', 77, 77160, 'NON', 'Site de la ville : www.mairie-provins.fr', '30 août et du 21 décembre au 1er janvier inclus', 48.4159333, 3.2393619, 'Ouvert en 2009 du 4 avril au 12 juin tous les jours de 12h à 17h30, du 13 juin au 13 septembre tous les jours de 11h à 18h30, du 14 septembre au 4 novembre tous les jours de 12h à 17h30, du 3 janvier au 3 avril et du 7 novembre au 20 décembre les week-end', 'musée'),
(100, 'Musée Départemental de l\'Ecole de Barbizon - Auberge Ganne', '92, Grande Rue', 'BARBIZON', 77, 77630, 'NON', 'www.seine-et-marne.fr (rubrique "loisirs/musées départementaux)', '1er janvier, 1er mai et 25 décembre - 22 décembre au 1er janvier 2010', 48.4461735, 2.60264197649649, 'Ouvert de 10h à 12h30 et de 14h à 17h30 en  juillet-août de 10h à 12h30 et de 14h à 18h', 'musée'),
(101, 'Musée d\'Archéologie Nationale (des origines à l\'an mille) - Château de st-Germain-en-Laye', 'Château\nPlace Charles de Gaulle', 'SAINT-GERMAIN-EN-LAYE Cedex', 78, 78105, 'NON', 'www.musee-antiquitesnationales.fr -www.musee-archeologienationale.fr', '', 48.89790425, 2.09614284207479, 'Ouvert de 10h à 17h15, du 1er mai au 30 septembre le week-end et jours fériés de 10h à 18h15', 'musée'),
(102, 'Musée de la Ville', 'B.P. 46', 'SAINT-QUENTIN-YVELINES Cedex', 78, 78185, 'NON', 'www.museedelaville.agglo-sqy.fr', 'Fermé du 13 juillet au 19 août', 48.7828, 2.041696, 'Ouvert du mercredi au vendredi de 14h à 18 le samedi et le premier dimanche du mois de 14h à 18h, mercredi, jeudi et vendredi toute la journée pour les scolaires et centres de loisirs et autres groupes', 'musée'),
(103, 'Musée de l\'Hôtel-Dieu', '1, Rue Thiers', 'MANTES-LA-JOLIE', 78, 78200, 'NON', 'http://musee.ville-mantes-la-jolie.com', '25 décembre, 1er janvier', 48.9895367, 1.7185578, 'Ouvert lundi, mercredi  à vendredi de 13h à 18h et de 9h à 12 pour les groupes, samedi de 10h à 18h, dimanche et jours fériés de 13h à 19h et du 1er novembre au 31 mars le lundi, mercredi au vendredi de 13h à 18h, samedi de 10h à 18h et dimanches et jours', 'musée'),
(104, 'Collections de la Fondation de Coubertin', 'Domaine de Coubertin', 'ST-REMY-LES-CHEVREUSE', 78, 78470, 'NON', 'www.coubertin.fr', '', 48.7010986, 2.05984525303321, 'Musée et parc ouverts pour tous pendant la période d\'exposition et le JEP et le reste de l\'année sur RDV pour les groupes (visites scolaires et visites-conférences). Exposition 2010 ouverte du vendredi au dimanche de 13h à 18h30', 'musée'),
(105, 'Musée Zola-Dreyfus', '26, Rue Pasteur', 'MEDAN', 78, 78670, 'NON', 'www.maisonzola-museedreyfus.com', '15 janvier au 28 février', 48.9554903, 1.9955326, 'Visites guidées samedi et jours fériés à 15h et 16h30, dimanche à 14h30, 15h30, 16h30 et 17h. Ouverture pour les groupes tous les jours sauf dimanche sur rdv. Pour les individuels, samedi, dimanche et jours fériés de 14h à 18h30', 'musée'),
(106, 'Musée du Château', 'Place du Général de Gaulle', 'DOURDAN', 91, 91410, 'NON', 'Site de la ville - www.mairie-dourdan.fr', 'Janvier, 25 décembre - Réouverture le 15 janvier à partir de 2010', 48.5293084, 2.0119847, 'Ouvert du mercredi au dimanche ainsi que les jours fériés de 10 h à 12 h et de 14 h à 18 h, 17h le vendredi', 'musée'),
(107, 'Musée Français de la Photographie', '78, Rue de Paris', 'BIEVRES', 91, 91570, 'NON', 'www.photographie.essonne.fr', 'Jours fériés', 48.7669793, 2.2294894, 'Ouvert du mercredi au lundi de 9h30 à 12h30 et de 13h30 à 17h30', 'musée'),
(108, 'Musée Départemental Albert-Kahn', '14, Rue du Port', 'BOULOGNE-BILLANCOURT', 92, 92100, 'NON', 'www.albert-kahn.fr', '25 décembre 2010 au 3 janvier 2011', 48.8412907, 2.2274406, 'Ouvert du mardi au dimanche de 11h à 18h d\'octobre à avril et de 11h à 19 h de mai à septembre', 'musée'),
(109, 'Musée René Sordes', 'Avenue Charles de Gaulle\nPasserelle des Arts', 'SURESNES', 92, 92150, 'OUI', 'www.ville-suresnes.fr/indexfin.html', '', 48.869353, 2.226254, '', 'musée'),
(110, 'Sèvres - Cité de la Céramique', '2, Place de la Manufacture', 'SEVRES', 92, 92310, 'NON', 'www.sevresciteceramique.fr', '1er janvier, 1er mai, 25 décembre', 48.8286879, 2.22304553191199, 'Les espaces d\'exposition sont ouverts tous les jours de 10h à 17h', 'musée'),
(111, 'Musée des Travaux Publics', 'Mairie de Courbevoie', 'COURBEVOIE', 92, 92400, 'OUI', 'Site de la ville', '', 48.89911185, 2.26830491425483, '', 'musée'),
(112, 'Musée d\'Histoire Locale - Mémoire de la Ville', '13, Boulevard Foch', 'RUEIL-MALMAISON Cedex', 92, 92501, 'NON', 'Site de la mairie : /www.mairie-rueilmalmaison.fr', 'Août et jours fériés', 48.870903, 2.166774, 'Ouvert du lundi au samedi de 14h30 à 18h', 'musée'),
(113, 'ARCHEA - Musée Intercommunal d\'Histoire et d\'Archéologie', '56, Rue de Paris', 'LOUVRES', 95, 95380, 'NON', 'http://www.archea-paysdefrance.fr', 'Entre le 25 décembre et le 1er janvier, et le 1er mai', 49.0368984, 2.5054487, 'Ouvert du mercredi au vendredi de 13h30 à 18h et le samedi et dimanche et jours fériés de 11h à 18h', 'musée'),
(114, 'Musée de la Renaissance - Château d\'Ecouen', 'Château', 'ECOUEN', 95, 95440, 'NON', 'www.musee-renaissance.fr ou www.musee-château-ecouen.fr', 'Les 1er janvier, 1er mai et 25 décembre', 49.01733295, 2.37836866741799, 'Ouvert du 1er octobre au 15 avril de 9h30 à 12h45 et de 14h00 à 17h15 et du 16 avril au 30 septembre de 9h30 à 12h45 et de 14h00 à 17h45', 'musée'),
(115, 'Musée Carnavalet-Histoire de Paris', '23, Rue de Sévigné', 'PARIS', 75, 75003, 'NON', 'www.paris.fr/musees/musee_carnavalet', 'Jours fériés', 48.8570542, 2.3628612, 'Ouvert du mardi au dimanche de 10h à 18h', 'musée'),
(116, 'Galerie de Botanique (Muséum National National d\'Histoire Naturelle)', '', 'PARIS', 75, 75005, 'OUI', '', '', 48.8415118, 2.3559666, '', 'musée'),
(117, 'Grande Galerie de l\'Evolution (Muséum National d\'Histoire Naturelle)', 'Jardin des Plantes\n36, rue Geoffroy Saint-Hilaire', 'PARIS', 75, 75005, 'NON', 'www.mnhn.fr', '1er mai', 48.8421181, 2.35623772399566, 'Ouvert du mercredi au lundi de 10h à 18h', 'musée'),
(118, 'Musée de l\'Assistance Publique - Hôpitaux de Paris', 'Hôtel de Miramion\n47, Quai de la Tournelle', 'PARIS', 75, 75005, 'NON', 'www.aphp.fr', 'Août et jours fériés', 48.850724, 2.3518758, 'Ouvert du mardi au dimanche de 10h à 18h du 1er janvier au 21 juillet 2010 et depuis le 4 novembre 2010 ouvert 1 jour/semaine (mardi ou jeudi) de 9h à 18 h', 'musée'),
(119, 'Musée National Eugène Delacroix', '6, Rue Furstenberg', 'PARIS', 75, 75006, 'NON', 'www.musee-delacroix.fr', '14 juillet', 48.85458545, 2.33563540987792, 'Ouvert du mercredi au lundi de 9h30 à 17h', 'musée'),
(120, 'Musée de Montmartre', '12, Rue Cortot', 'PARIS', 75, 75018, 'NON', 'www.museedemontmartre.com', '1er janvier, 1er mai et 25 décembre', 48.8877198, 2.340529, 'Ouvert du mardi au dimanche de 11h à 18h toute l\'année', 'musée'),
(121, 'Musée des Monuments Français', 'Palais de Chaillot\n1, Place du Trocadéro et du 11 Novembre', 'PARIS', 75, 75116, 'NON', 'www.citechaillot.fr', '1er janvier, 1er mai, 25 décembre', 48.86289005, 2.28904154902233, 'Ouvert lundi, mercredi, vendredi au dimanche de 11h à 19h, le jeudi de 11h à 21h', 'musée'),
(122, 'Musée des Monnaies et des Médailles', '11, Quai de Conti', 'PARIS Cedex 06', 75, 75270, 'TRAVAUX', 'www.monnaiedeparis.fr', '', 48.8574815, 2.3380657, 'Ouvert du mardi au vendredi de 11h à 17h30 et le samedi et dimanche de 12h à 17h30', 'musée'),
(123, 'Musée Municipal', 'Place de Samois', 'MORET-SUR-LOING', 77, 77250, 'NON', '', '', 48.37366435, 2.81483843501796, 'Ouvert du vendredi au lundi de 14h à 18h30 de novembre à mars et de 14h à 19h d\'avril à septembre', 'musée'),
(124, 'Musée Henri Chapu', '937, Rue Chapu', 'LE MEE-SUR-SEINE', 77, 77350, 'NON', 'Site de la ville', 'Août', 48.534725, 2.6353597553476, 'Ouvert les samedis et dimanches de 15h à 18h l\'été et de 14h à 17h l\'hiver', 'musée'),
(125, 'Musée des Transports Urbains, Interurbains et Ruraux', '1, Rue Gabriel de Mortillet', 'CHELLES', 77, 77500, 'OUI', 'www.amtuir.org', '', 48.8769357, 2.605593, '', 'musée'),
(126, 'Musée départemental Stéphane Mallarmé', 'Pont de Valvins\n4, Promenade Stéphane Mallarmé', 'VULAINES-SUR-SEINE', 77, 77870, 'NON', 'www.weine-et-marne.fr (rubrique "loisirs/musées départementaux)', '24 décembre au 31 décembre, 1er mai', 48.430797, 2.750221300000021, 'Ouvert du mercredi au lundi de septembre à juin de 10h à 12h30 et de 14h à 17h30, juillet- août de 10h à 12h30 et de 14h à 18h', 'musée'),
(127, 'Musée Lambinet', '54, Boulevard de la Reine', 'VERSAILLES', 78, 78000, 'NON', 'www.musee-lambinet.com', '1er janvier, dimanche et lundi de Pâques, 1er mai, ascension, lundi de Pentecôte, 8 mai, 14 juillet, 1er et 11 novembre, 25 décembre', 48.8080061, 2.1449823, 'Ouvert du lundi au jeudi et du samedi au dimanche de 14h à 18h', 'musée'),
(128, 'Musée Municipal', 'Jardin des Arts\nPlace André Malraux', 'SAINT-GERMAIN-EN-LAYE', 78, 78100, 'OUI', '', '', 48.8967782, 2.09680049761021, '', 'musée'),
(129, 'Musée d\'Art et d\'Histoire', '12, Rue Saint-Louis', 'POISSY', 78, 78300, 'OUI', 'Site de la ville', '', 48.9325465, 2.0384812, '', 'musée'),
(130, 'Musée Belmondo et de la Sculpture Figurative du XXè siècle', 'Château Buchillot\n14, Rue de l\'Abreuvoir', 'BOULOGNE-BILLANCOURT', 92, 92100, 'NON', 'http://www.boulognebillancourt.com', '1er janvier, 1er mai, 25 décembre', 48.8497605, 2.23358458635328, 'Ouvert du mardi au vendredi de 14h à 18h et du samedi au dimanche de 11h à 18h', 'musée'),
(131, 'Fondation Arp', '21, Rue des Châtaigniers', 'CLAMART', 92, 92140, 'NON', 'www.fondationarp.org', 'Août, semaine entre Noël et Nouvel An', 48.8034865, 2.2442946, 'Ouverture les vendredi, samedi, dimanche de 14 à 18h et sur rendez-vous', 'musée'),
(132, 'Musée Roybet Fould', 'Parc de Bécon\n178, Boulevard Saint Denis', 'COURBEVOIE', 92, 92400, 'NON', '', 'Fermé le 1er janvier, 1er mai, Pâques, Toussaint, Noël', 48.899894, 2.268394, 'Ouvert du mercredi au lundi de 10h30 à 18h', 'musée'),
(133, 'Musée Franco-Suisse', '13, Boulevard Foch', 'RUEIL-MALMAISON Cedex', 92, 92501, 'NON', 'Site de la mairie : /www.mairie-rueilmalmaison.fr', 'Juillet et août', 48.878344, 2.180364, 'ouvert tous les jeudis de 14h30 à 18h ou sur rendez-vous les autres jours', 'musée'),
(134, 'Musée de l\'Air et de l\'Espace', 'Aéroport de Paris - Le Bourget\nBP 173', 'LE BOURGET Cedex', 93, 93352, 'NON', 'www.museeairespace.fr', '25 décembre, 1er janvier', 48.95871155, 2.4365200449124, 'Ouvert du mardi au dimanche d\'octobre à mars de 10h à 17h et d\'avril à septembre de 10h à 18h', 'musée'),
(135, 'Musée de Nogent-Sur-Marne', '36, Boulevard Gallieni', 'NOGENT-SUR-MARNE', 94, 94130, 'NON', 'www.musee-nogentsurmarne.fr', 'Jours fériés', 48.8505872, 2.4754614, 'Ouvert du mardi au jeudi, dimanche, de 14h à 18 h, et le samedi de 10h à 12h et de 14h à 18h. Tous les jours pour les groupes sauf jours fériés', 'musée'),
(136, 'Musée Adrien Mentienne', '1, Grande Rue Charles de Gaulle', 'BRY-SUR-MARNE', 94, 94360, 'OUI', 'http://www.bry94.fr/bry/71.htm', '', 48.8371327, 2.5207996, 'Ouvert du lundi au vendredi de  9h à 12h et de 14h à 18h, samedi de 9h à 12h', 'musée'),
(137, 'Musée d\'Art Contemporain du Val-de-Marne', 'Place de la Libération\nB.P. 147', 'VITRY SUR SEINE Cedex', 94, 94404, 'NON', 'www.macval.fr', 'Les 1er janvier, 1er mai et 25 décembre', 48.7931585, 2.38801885261606, 'Ouvert le mardi, mercredi, vendredi, samedi, dimanche de 12h à 19h et le jeudi de 12h à 21h', 'musée'),
(138, 'Musée du Vieil Argenteuil', '5, rue Pierre-Guienne', 'ARGENTEUIL', 95, 95100, 'NON', 'Site de la ville - www.argenteuil.fr/article.php3?id_article=529', 'Août', 48.9443065, 2.2569192, 'Ouvert mercredi et premier dimanche du mois de 14h à 17h30 (hors expos), mercredi et dimanche de 14h à 17h30 pendant la période d\'exposition, tous les jours sur réservation pour les groupes', 'musée'),
(139, 'Musée d\'Art et d\'Histoire Louis Senlecq', '46, Grande Rue', 'L\'ISLE-ADAM', 95, 95290, 'OUI', 'http://musee.ville-isle-adam.fr/index.html', '', 49.1122314, 2.2164925, 'Ouvert du mercredi au lundi de 14h à 18h', 'musée'),
(140, 'Atelier de Jean-François Millet, ParcGâtinais français', '27, Grande-Rue', 'Barbizon', 77, 77630, '', 'http://www.atelier-millet.fr', '', 48.44364, 2.60746, 'Tous les jours (sf mardi), 9h30-12h30 et 14h00-17h30.', 'parc'),
(141, 'Moulin de Claude François, ParcGâtinais français', '32, rue du Moulin', 'Dannemois', 91, 91490, '', 'http://www.moulindedannemois.com', '', 48.454469, 2.479817, 'Visites guidées et commentées tous les jours (sf mercredi) : 11h-12h et 14h-16h (17h le week-end).', 'parc'),
(142, 'Le Cyclop, ParcGâtinais français', 'Le Bois des pauvres, rue Louis Pasteur.', 'Milly-la-Forêt', 91, 91490, '', 'http://www.lecyclop.com', '', 48.414947, 2.456763, 'Avril à novembre : samedi & dimanche, 13h30-18h (+ vendredi en juillet-août)', 'parc'),
(143, 'Palais du Roi de Rome, ParcHaute Vallée de Chevreuse', 'Place du Roi de Rome', 'Rambouillet', 78, 78120, '', 'www.rambouillet.fr', '', 48.644327, 1.822259, 'tous les jours, 14h-18h (pour le jardin). Horaires des expositions variables.', 'parc'),
(144, 'Parc de sculptures de Robert Le Lagadec, ParcHaute Vallée de Chevreuse', '20, rue du bon puits', 'Fontenay-lès-Briis', 91, 91470, '', 'NC', '', 48.619686, 2.158069, 'visite tous les jours sur rendez-vous', 'parc'),
(145, 'Musée d’Art et d’Archéologie, ParcOise – Pays de France', 'Place du parvis Notre-Dame', 'Senlis', 60, 60300, '', 'http://www.musees-senlis.fr', '', 49.206383, 2.586139, 'Lundi, jeudi et vendredi : 10h-12h et 14h-18h\nMercredi : 14h-18h\nSamedi, dimanche et jours fériés : 11h-13h et 14h-18h.', 'parc'),
(146, 'Moulin de la Naze, ParcVexin français', 'Rue du moulin Morel', 'Valmondois', 95, 95760, '', 'http://www.pnr-vexin-francais.fr', '', 49.107046, 2.183586, 'Du 01/03 au 14/07 et du 01/09 au 15/12 : samedi, 14h-18h / Dimanche, 10h-12h et 14h-18h', 'parc'),
(147, 'Musée de l’Absinthe, ParcVexin français', '44, rue Callé', 'Auvers-sur-Oise', 95, 95430, '', 'http://www.musee-absinthe.com', '', 49.071655, 2.167967, '. De mars à novembre : samedi, dimanche et jours fériés, 13h30-18h\n. Du 15/06 au 01/09 : du mercredi au dimanche, 13h30-18h', 'parc'),
(148, 'Musée des tramways à vapeur et chemins de fer secondaires français, ParcVexin français', 'Place de la gare', 'Butry-sur-Oise', 95, 95430, '', 'http://www.musee-mtvs.com', '', 49.091522, 2.201545, '. De mai à octobre : dimanche et jours fériés, 14h30-18h.\n. Démonstrations de trains historiques le 1er et 3e dimanche du mois', 'parc'),
(149, 'Musée Municipal de l’Ecole de Barbizon, ParcGâtinais français', 'Dans l\'auberge Ganne - 92, Grande-rue', 'Barbizon', 77, 77630, '', 'http://musee-peintres-barbizon.fr/', '', 48.446208, 2.602649, 'Tous les jours, sauf le mardi, de 10h à 12h30 et de 14h à 17h30 et jusqu’à 18h en juillet et août.', 'parc'),
(150, 'Musée des traditions, ParcGâtinais français', '18, rue du Closeau', 'Achères-la-Forêt', 77, 77760, '', 'NC', '', 48.342794, 2.564269, 'Avril à octobre - 2e week-end de chaque mois : 14h-18h \nJuillet-août - Samedi et dimanche : 14h-18h\nVisites possibles en dehors des horaires d\'ouverture sur réservation préalable.', 'parc'),
(151, 'Maison de Jean Monnet, ParcHaute Vallée de Chevreuse', '7, chemin du Vieux Pressoir', 'Bazoches-sur-Guyonne', 78, 78490, '', 'http://www.ajmonnet.eu', '', 48.770624, 1.852431, 'Du lundi au vendredi : 10h-17h. Samedi : 13h-18h. Dimanche : 10h-18h. Fermeture à 17h de mi-octobre à mi-avril.', 'parc'),
(152, 'Maison de Maurice Ravel, ParcHaute Vallée de Chevreuse', '5 rue Maurice Ravel', 'Montfort-l\'Amaury', 78, 78490, '', 'NC', '', 48.776233, 1.805411, 'Visite guidée uniquement. Samedi et dimanche : 10h, 11h, 14h30, 15h30 et 16h30. Sur réservation pour les groupes.', 'parc'),
(153, 'Eco-musée de la Cartoucherie, ParcOise – Pays de France', 'Grande-rue', 'Survilliers', 95, 95470, '', 'NC', '', 49.095306, 2.544456, 'Mardi : 9h-12h. Visite possible également sur rendez-vous.', 'parc'),
(154, 'Musée Condé, ParcOise – Pays de France', 'Au cœur du domaine de Chantilly', 'Chantilly', 60, 60500, '', 'http://www.domainedechantilly.com', '', 49.194517, 2.486134, 'Du 29/03 au 02/11 - Tous les jours : 10h-18h.', 'parc'),
(155, 'Musée d’histoire locale, ParcOise – Pays de France', 'Dans la mairie - Place Pierre Salvi', 'Viarmes', 95, 95270, '', 'NC', '', 49.126101, 2.368637, 'Vendredi : 14h30-17h30.', 'parc'),
(156, 'Musée du Cheval, ParcOise – Pays de France', '7, rue du Connétable', 'Chantilly', 60, 60500, '', 'http://www.grandesecuries.com/', '', 49.194271, 2.479575, 'Tous les jours : 10h-18h.', 'parc'),
(157, 'Espace Culturel Paul-Bédu, ParcGâtinais français', '8 bis, rue Farnault', 'Milly-la-Forêt', 91, 91490, '', 'NC', '', 48.402991, 2.466732, 'du mercredi au dimanche : 14h-18h (17h de novembre à mars)\n\nVisites pour groupes et scolaires toute l\'année sur réservation (y compris en-dehors des horaires d\'ouverture).', 'parc'),
(158, 'Maison d\'Elsa Triolet et Louis Aragon, ParcHaute Vallée de Chevreuse', 'Rue de la Villeneuve', 'Saint-Arnoult-en-Yvelines', 78, 78730, '', 'http://www.maison-triolet-aragon.com', '', 48.568719, 1.926273, 'Samedi, dimanche et jours fériés : 14h-18h. Visites guidées uniquement.', 'parc'),
(159, 'Musée Rambolitrain, ParcHaute Vallée de Chevreuse', '4, place Jeanne d\'Arc', 'Rambouillet', 78, 78120, '', 'http://www.rambolitrain.com/', '', 48.645895, 1.824377, 'Du mercredi au dimanche, et les jours fériés : 10h-12h et 14h-17h30. Visites guidées sur réservation pour les groupes à partir de 15 personnes.', 'parc'),
(160, 'Musée des Spahis, ParcOise – Pays de France', 'Place du parvis Notre-Dame', 'Senlis', 60, 60300, '', 'http://www.musees-senlis.fr', '', 49.207053, 2.585005, 'Mardi : 14h-18h\nMercredi, jeudi et vendredi : 10h-12h et 14h-18h.\nSamedi, dimanche et jours fériés : 11h-13h et 14h-18h.', 'parc'),
(161, 'Musée Gallé-Juillet, ParcOise – Pays de France', 'Place François Mitterrand', 'Creil', 60, 60100, '', 'http://www.creil.fr/musee-galle-juillet', '', 49.260927, 2.473327, 'Du mercredi au samedi : 14h-17h. Dimanche : 14h30-17h30.', 'parc'),
(162, 'Auberge Ravoux, dite "Maison Van Gogh", ParcVexin français', '52, rue du Général de Gaulle', 'Auvers-sur-Oise', 95, 95430, '', 'http://www.maisondevangogh.fr', '', 49.070825, 2.171539, 'du mercredi au dimanche, 10h30-18h30 (avril à fin octobre)', 'parc'),
(163, 'Musée archéologique du Val-d\'Oise, ParcVexin français', 'Musée Archéologique Départemental du Val d\'Oise Rue saint-nicolas', 'Guiry-en-Vexin', 95, 95450, '', 'NC', '', 49.109078, 1.850729, 'Du lundi au vendredi (sf mardi) : 9h-12h et 13h30-17h30 / Samedi, dimanche et jours fériés : 10h-12h et 14h-19h du (13h30-18h30 du 15/10 au 14/03).', 'parc'),
(164, 'Musée de l’Outil, ParcVexin français', '2, rue de la mairie', 'Wy-dit-Joli-Village', 95, 95420, '', 'NC', '', 49.103111, 1.835661, 'Mercredi et vendredi : 13h30-17h30 / Samedi, dimanche jours fériés : 14h-18h30. Fermé de novembre à février inclus.', 'parc'),
(165, 'Musée de la Moisson, ParcVexin français', '6 La Côte du Petit Mesnil', 'Sagy', 95, 95450, '', 'http://www.pnr-vexin-francais.fr', '', 49.058387, 1.948614, 'dimanche, 14h-18h (De mars à fin octobre) - En semaine sur rendez-vous.', 'parc'),
(166, 'Musée des vieux métiers, ParcGâtinais français', '55, rue Haute', 'Bouray-sur-Juine', 91, 91850, '', 'NC', '', 48.518963, 2.295351, 'Le 1er et 3e week-end de chaque mois, 14h-17h (visite guidée).', 'parc'),
(167, 'Musée des Arts et traditions populaires, ParcHaute Vallée de Chevreuse', 'Rue de Nuisement', 'Saint-Arnoult-en-Yvelines', 78, 78730, '', 'NC', '', 48.572863, 1.950654, 'Du 01/04 au 30/09 - Le dernier dimanches de chaque mois, 14h30-18h', 'parc'),
(168, 'Port-Royal des Champs, ParcHaute Vallée de Chevreuse', 'Accès au parc par la D91', 'Magny-les-Hameaux', 78, 78114, '', 'www.port-royal-des-champs.eu', '', 48.74441767602123, 2.0159912109375, '. Du 01/11 au 31/03 : du lundi au vendredi, 10h-12h et 14h-17h30 / samedi, dimanche et jours fériés, 10h30-18h\n. Du 01/04 au 31/10 : du lundi au vendredi, 10h30-12h et 14h-18h / samedi, dimanche et jours fériés, 10h30-18h30', 'parc'),
(169, 'Musée de la Mémoire des murs, ParcOise – Pays de France', 'Place de Piegaro', 'Verneuil-en-Halatte', 60, 60550, '', 'http://www.memoiredesmurs.com', '', 49.2739, 2.516495, 'Tous les jours (sf mardi) : 14h-18h. Visites guidées sur rendez-vous pour les groupes.', 'parc'),
(170, 'Musée de la Vénerie, ParcOise – Pays de France', 'Place du parvis Notre-Dame', 'Senlis', 60, 60300, '', 'http://http://www.musees-senlis.fr/', '', 49.207053, 2.585005, 'Mardi : 14h-18h\nMercredi, jeudi et vendredi : 10h-12h et 14h-18h.\nSamedi, dimanche et jours fériés : 11h-13h et 14h-18h.', 'parc'),
(171, 'Musée Daubigny, ParcVexin français', 'Manoir des Colombieres rue de la Sansonne', 'Auvers-sur-Oise', 95, 95430, '', 'http://www.musee-daubigny.com', '', 49.071258, 2.171744, 'Mercredi, jeudi et vendredi : 14h-17h30 (17h de novembre à mars) / Samedi, dimanche et jours fériés : 10h30-12h30 et 14h-18h (17h30 de novembre à mars).', 'parc'),
(172, 'Domaine départemental de Chamarande, ParcGâtinais français', '38 rue du Commandant Arnoux', 'Chamarande', 91, 91730, '', 'http://chamarande.essonne.fr/', '', 48.513938, 2.217792, 'Octobre - Tous les jours : 9h-18h\nNovembre, décembre, janvier - Tous les jours : 9h-17h\nFévrier, mars - Tous les jours : 9h-18h\nAvril, mai - Tous les jours : 9h-19h\nJuin à septembre - Tous les jours : 9h-20h', 'parc'),
(173, 'Musée Volant Salis, ParcGâtinais français', 'Aérodrome de la Ferté Alais', 'Cerny', 91, 91590, '', 'http://www.musee-volant-salis.fr/', '', 48.499525, 2.330515, 'Tous les jours (sf jeudi) : 9h-12h et 14h-17h.', 'parc'),
(174, 'Ecomusée de Boigneville, ParcGâtinais français', '8, place de l’Eglise', 'Boigneville', 91, 91720, '', 'NC', '', 48.335397, 2.37205, 'Premier dimanche de chaque mois : 14h-18h. Visites possibles également sur rendez-vous.', 'parc'),
(175, 'Fondation de Coubertin, ParcHaute Vallée de Chevreuse', 'Domaine de Coubertin', 'Saint-Rémy-lès-Chevreuse', 78, 78470, '', 'http://www.coubertin.fr/fondation-coubertin', '', 48.70161107544582, 2.0612239837646484, '. De mai à mi-juillet : samedi et dimanche, 13h30-18h30.\n. La Fondation propose également des évènements ponctuels. Consultez le calendrier sur son site.', 'parc'),
(176, 'Maison Louis Carré, ParcHaute Vallée de Chevreuse', '2, chemin du Saint-Sacrement', 'Bazoches-sur-Guyonne', 78, 78490, '', 'http://www.maisonlouiscarre.fr', '', 48.770214, 1.852644, 'De mars à novembre - Samedi et dimanche : 14h-18h. Visite guidée toutes les heures.', 'parc'),
(177, 'Musée Jacquemart-André, ParcOise – Pays de France', 'Au cœur du domaine de Chaalis - Accès par la RN 330', 'Fontaine-chaalis', 60, 60300, '', 'http://www.chaalis.fr', '', 49.14817, 2.685853, '', 'parc');
INSERT INTO `musee` (`id`, `nom`, `adresse`, `ville`, `departement`, `codep`, `ferme`, `siteweb`, `fermeture_annuelle`, `latitude`, `longitude`, `periode_ouvertue`, `type`) VALUES
(178, 'Maison du Docteur Gachet, ParcVexin français', '78, rue du Docteur Gachet', 'Auvers-sur-Oise', 95, 95430, '', 'NC', '', 49.071859, 2.156135, 'D\'avril à fin octobre - Du mercredi au dimanche : 10h30-18h30.', 'parc'),
(179, 'Maison du Pain, ParcVexin français', '31, grande rue', 'Commeny', 95, 95450, '', 'http://www.pnr-vexin-francais.fr', '', 49.1264, 1.89123, 'dimanche, 14h-18h (de mars à fin octobre). Visites de groupe sur rendez-vous, même en dehors des horaires d\'ouverture.', 'parc'),
(180, 'Musée du Vexin français, ParcVexin français', 'Maison du Parc', 'Théméricourt', 95, 95450, '', 'http://www.pnr-vexin-francais.fr', '', 49.086602, 1.896207, 'Du mardi au vendredi : 9h-12h30 et 14h-18h / Samedi : 14h-18h / Dimanche et jours fériés : 10h-19h (14h-18h d\'octobre-avril).', 'parc'),
(181, 'Autour du bois de Morval, ParcVexin français', 'Rue Saint-Nicolas', 'Guiry-en-Vexin', 95, 95450, '', 'NC', '', 49.109042, 1.850719, '', 'parc'),
(182, 'Château de Dourdan, ParcHaute Vallée de Chevreuse', 'Rue des Fossés du Château', 'Dourdan', 91, 91410, '', 'http://www.mairie-dourdan.fr', '', 48.52968, 2.010415, 'Du mercredi au dimanche : 10h-12h et 14h-18h (17h le vendredi), ainsi que tous les jours fériés.', 'parc'),
(183, 'En pays de France, ParcOise – Pays de France', '', 'Survilliers-Fosses', 95, 95470, '', 'NC', '', 0, 0, '', 'parc'),
(184, 'L’antique forêt d’Halatte, ParcOise – Pays de France', 'Parc de Verneuil', 'Verneuil-en-Halatte', 60, 60550, '', 'NC', '', 49.2691, 2.51615, '', 'parc'),
(185, 'Abbaye de Chaalis, ParcOise – Pays de France', 'RN 330', 'Fontaine-chaalis', 60, 60300, '', 'http://www.chaalis.fr', '', 49.14817, 2.685853, 'Tous les jours, 10h à 18h (sf 25/12 et 01/01). Sur réservation pour les groupes.', 'parc'),
(186, 'Jardins de l\'abbaye de Royaumont, ParcOise – Pays de France', '', 'Asnières-sur-Oise', 95, 95270, '', 'http://www.royaumont.com', '', 49.147707, 2.381154, 'Tous les jours : 10h-18h (17h30 de novembre à février).', 'parc'),
(187, 'Entre Juine et Essonne, ParcGâtinais français', '', 'Orveau', 91, 91590, '', 'NC', '', 48.4430572, 2.297820999999999, '', 'parc'),
(188, 'Domaine de Chantilly, ParcOise – Pays de France', 'Château de Chantilly,', 'Chantilly', 60, 60500, '', 'http://www.domainedechantilly.com', '', 49.193896, 2.485359, 'Consulter le site Internet du domaine pour connaître les horaires des différents espaces.', 'parc'),
(189, 'Sur les chemins de traverse, ParcHaute Vallée de Chevreuse', '', 'Monfort-L\'Amaury', 78, 78490, '', 'NC', '', 48.802838, 1.815351, '', 'parc'),
(190, 'Le circuit des anciennes gares, ParcVexin français', 'Maison du Parc', 'Théméricourt', 95, 95450, '', 'NC', '', 49.086738, 1.897069, '', 'parc'),
(191, 'musee test', NULL, NULL, 0, 0, NULL, NULL, NULL, 0, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `codep` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Indexes for dumped tables
--

--
-- Indexes for table `affluence`
--
ALTER TABLE `affluence`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_musee` (`id_musee`);

--
-- Indexes for table `favoris`
--
ALTER TABLE `favoris`
  ADD PRIMARY KEY (`id_user`,`id_musee`),
  ADD KEY `fk_user` (`id_user`),
  ADD KEY `fk_musee` (`id_musee`);

--
-- Indexes for table `musee`
--
ALTER TABLE `musee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `affluence`
--
ALTER TABLE `affluence`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `musee`
--
ALTER TABLE `musee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=192;
--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `affluence`
--
ALTER TABLE `affluence`
  ADD CONSTRAINT `affluence_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `affluence_ibfk_2` FOREIGN KEY (`id_musee`) REFERENCES `musee` (`id`);

--
-- Constraints for table `favoris`
--
ALTER TABLE `favoris`
  ADD CONSTRAINT `fk_musee` FOREIGN KEY (`id_musee`) REFERENCES `musee` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;