select numero as Aula, concat(apellido,', ' ,nombre) as Docente, nombremat as Materia, concat(hora_inicio,'-' ,hora_fin) as Modulo
from reserva r, aula a, docente d, materia mat, modulo m
where r.idaula = a.idaula and r.idocente = d.idocente and r.idmateria = mat.idmateria and r.idmodulo = m.idmodulo 
and r.fecha_reserva = "2017-06-23"
