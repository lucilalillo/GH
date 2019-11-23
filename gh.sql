-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2019 a las 15:54:16
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gh`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cantidad_camas`
--

CREATE TABLE `cantidad_camas` (
  `ID_TIPOHABITACION` int(11) NOT NULL,
  `ID_TIPOCAMA` int(11) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `NUMERO` int(11) NOT NULL,
  `PISO` int(11) DEFAULT NULL,
  `ESTADO` varchar(20) DEFAULT NULL,
  `TIPOHABITACION` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `ID_HUESPED` int(11) NOT NULL,
  `NOMBRE` varchar(200) DEFAULT NULL,
  `DOMICILIO` varchar(200) DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `CELULAR` int(11) DEFAULT NULL,
  `CORREO` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `ID_HUESPED` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `IMPORTE` double DEFAULT NULL,
  `CANT_PERSONAS` int(11) DEFAULT NULL,
  `FECHA_INGRESO` date DEFAULT NULL,
  `FECHA_EGRESO` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cama`
--

CREATE TABLE `tipo_cama` (
  `ID_TIPOCAMA` int(11) NOT NULL,
  `TIPO` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_habitacion`
--

CREATE TABLE `tipo_habitacion` (
  `ID_TIPOHABITACION` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) DEFAULT NULL,
  `PRECIO` double DEFAULT NULL,
  `NUMERO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cantidad_camas`
--
ALTER TABLE `cantidad_camas`
  ADD PRIMARY KEY (`ID_TIPOHABITACION`,`ID_TIPOCAMA`),
  ADD KEY `ID_TIPOCAMA` (`ID_TIPOCAMA`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`NUMERO`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`ID_HUESPED`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`ID_HUESPED`,`NUMERO`),
  ADD KEY `NUMERO` (`NUMERO`);

--
-- Indices de la tabla `tipo_cama`
--
ALTER TABLE `tipo_cama`
  ADD PRIMARY KEY (`ID_TIPOCAMA`);

--
-- Indices de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD PRIMARY KEY (`ID_TIPOHABITACION`),
  ADD KEY `NUMERO` (`NUMERO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `NUMERO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `ID_HUESPED` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_cama`
--
ALTER TABLE `tipo_cama`
  MODIFY `ID_TIPOCAMA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  MODIFY `ID_TIPOHABITACION` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cantidad_camas`
--
ALTER TABLE `cantidad_camas`
  ADD CONSTRAINT `cantidad_camas_ibfk_1` FOREIGN KEY (`ID_TIPOHABITACION`) REFERENCES `tipo_habitacion` (`ID_TIPOHABITACION`),
  ADD CONSTRAINT `cantidad_camas_ibfk_2` FOREIGN KEY (`ID_TIPOCAMA`) REFERENCES `tipo_cama` (`ID_TIPOCAMA`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`ID_HUESPED`) REFERENCES `huesped` (`ID_HUESPED`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`NUMERO`) REFERENCES `habitacion` (`NUMERO`);

--
-- Filtros para la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD CONSTRAINT `tipo_habitacion_ibfk_1` FOREIGN KEY (`NUMERO`) REFERENCES `habitacion` (`NUMERO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
