select idaula as Aula, nombremat as Materia, concat(hora_inicio,'-' ,hora_fin) as Modulo 
from reserva r join docente d join materia mat join modulo m
where d.idocente = 1 and r.idocente = 1 and r.idmodulo = m.idmodulo and r.idmateria = mat.idmateria;