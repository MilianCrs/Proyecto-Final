-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2024 a las 23:25:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `traveltogether`
--
CREATE DATABASE IF NOT EXISTS `traveltogether` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `traveltogether`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alojamiento`
--

CREATE TABLE `alojamiento` (
  `codAlojam` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `nroAmbientes` int(11) DEFAULT NULL,
  `camas` varchar(100) DEFAULT NULL,
  `banios` int(11) DEFAULT NULL,
  `precioNoche` double DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `hab1` int(11) DEFAULT NULL,
  `hab2` int(11) DEFAULT NULL,
  `hab3` int(11) DEFAULT NULL,
  `ciudad` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alojamiento`
--

INSERT INTO `alojamiento` (`codAlojam`, `nombre`, `capacidad`, `nroAmbientes`, `camas`, `banios`, `precioNoche`, `tipo`, `hab1`, `hab2`, `hab3`, `ciudad`) VALUES
(22, 'Las Flores', 4, 3, 'individuales', 1, 23000, 'Cabaña', NULL, NULL, NULL, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `codCiudad` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `continente` varchar(100) DEFAULT NULL,
  `rol` varchar(100) DEFAULT NULL,
  `inicioTemp` datetime DEFAULT NULL,
  `finTemp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`codCiudad`, `nombre`, `pais`, `continente`, `rol`, `inicioTemp`, `finTemp`) VALUES
(9, 'Bariloche Rio Negro', 'Argentina', NULL, 'Origen-Destino', '2024-01-01 00:00:00', '2024-12-23 00:00:00'),
(17, 'La Carolina San Luis ', 'Argentina', NULL, 'Destino', '2024-11-01 00:00:00', '2025-11-15 00:00:00'),
(5, 'Merlo San Luis', 'Argentina', NULL, 'Origen-Destino', '2024-12-01 00:00:00', '2025-12-23 00:00:00'),
(2, 'San Luis ', 'Argentina ', NULL, 'Origen', NULL, NULL),
(13, 'San pablo', 'Brasil', NULL, 'Destino', '2024-11-01 00:00:00', '2025-11-29 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `idCompra` int(11) NOT NULL,
  `codPaquete` int(11) DEFAULT NULL,
  `ciudad` varchar(200) DEFAULT NULL,
  `temporada` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `nroHab` int(11) NOT NULL,
  `planta` int(11) DEFAULT NULL,
  `numerac` int(11) DEFAULT NULL,
  `cupo` int(11) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `codAlojamiento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE `paquete` (
  `codPaquete` int(11) NOT NULL,
  `fechaIni` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `boleto` int(11) DEFAULT NULL,
  `estadia` int(11) DEFAULT NULL,
  `regimen` int(11) DEFAULT NULL,
  `origen` varchar(100) DEFAULT NULL,
  `destino` varchar(100) DEFAULT NULL,
  `traslados` float DEFAULT NULL,
  `montoFinal` double DEFAULT NULL,
  `dni_turista` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasaje`
--

CREATE TABLE `pasaje` (
  `CodPasaje` int(11) NOT NULL,
  `fechaHora` date DEFAULT NULL,
  `origen` varchar(100) DEFAULT NULL,
  `destino` varchar(100) DEFAULT NULL,
  `asiento` int(11) DEFAULT NULL,
  `transporte` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasaje`
--

INSERT INTO `pasaje` (`CodPasaje`, `fechaHora`, `origen`, `destino`, `asiento`, `transporte`) VALUES
(1, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pension`
--

CREATE TABLE `pension` (
  `codAdicional` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `porcentaje` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turista`
--

CREATE TABLE `turista` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `telefono` bigint(11) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `turista`
--

INSERT INTO `turista` (`dni`, `nombre`, `apellido`, `edad`, `telefono`, `correo`) VALUES
(44954644, 'milian', 'caceres', 21, 2264643178, 'miliancaceres@gmail.com'),
(47266622, 'Martin', 'Becerra', 18, 2664304069, 'martinbecerrasl7@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  ADD PRIMARY KEY (`codAlojam`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `hab1` (`hab1`,`hab2`,`hab3`),
  ADD KEY `habitaciones1` (`hab2`),
  ADD KEY `habitaciones2` (`hab3`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`nombre`),
  ADD UNIQUE KEY `codCiudad` (`codCiudad`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `codPaquete` (`codPaquete`,`ciudad`),
  ADD KEY `ciudadcompra` (`ciudad`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`nroHab`),
  ADD KEY `codAlojamiento` (`codAlojamiento`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`codPaquete`),
  ADD KEY `boleto` (`boleto`,`estadia`,`regimen`),
  ADD KEY `estadiaAlojamiento` (`estadia`),
  ADD KEY `regimenPension` (`regimen`),
  ADD KEY `origen` (`origen`,`destino`),
  ADD KEY `ciudadDestino` (`destino`),
  ADD KEY `dni_turista` (`dni_turista`);

--
-- Indices de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD PRIMARY KEY (`CodPasaje`),
  ADD KEY `origen` (`origen`,`destino`),
  ADD KEY `destino` (`destino`);

--
-- Indices de la tabla `pension`
--
ALTER TABLE `pension`
  ADD PRIMARY KEY (`codAdicional`);

--
-- Indices de la tabla `turista`
--
ALTER TABLE `turista`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `codCiudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  MODIFY `CodPasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  ADD CONSTRAINT `habitaciones` FOREIGN KEY (`hab1`) REFERENCES `habitacion` (`nroHab`),
  ADD CONSTRAINT `habitaciones1` FOREIGN KEY (`hab2`) REFERENCES `habitacion` (`nroHab`),
  ADD CONSTRAINT `habitaciones2` FOREIGN KEY (`hab3`) REFERENCES `habitacion` (`nroHab`);

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `ciudadcompra` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`nombre`),
  ADD CONSTRAINT `codpaquete` FOREIGN KEY (`codPaquete`) REFERENCES `paquete` (`codPaquete`);

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `aloHabitacion` FOREIGN KEY (`codAlojamiento`) REFERENCES `alojamiento` (`codAlojam`);

--
-- Filtros para la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD CONSTRAINT `boletoPasaje` FOREIGN KEY (`boleto`) REFERENCES `pasaje` (`CodPasaje`),
  ADD CONSTRAINT `ciudadDestino` FOREIGN KEY (`destino`) REFERENCES `ciudad` (`nombre`),
  ADD CONSTRAINT `ciudadOrigen` FOREIGN KEY (`origen`) REFERENCES `ciudad` (`nombre`),
  ADD CONSTRAINT `dni_turista` FOREIGN KEY (`dni_turista`) REFERENCES `turista` (`dni`),
  ADD CONSTRAINT `estadiaAlojamiento` FOREIGN KEY (`estadia`) REFERENCES `alojamiento` (`codAlojam`),
  ADD CONSTRAINT `regimenPension` FOREIGN KEY (`regimen`) REFERENCES `pension` (`codAdicional`);

--
-- Filtros para la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD CONSTRAINT `destino` FOREIGN KEY (`destino`) REFERENCES `ciudad` (`nombre`),
  ADD CONSTRAINT `origen` FOREIGN KEY (`origen`) REFERENCES `ciudad` (`nombre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
