
export class Persona{
    id:number;
    nombre:string;
    apellido:string;
    urlfoto:string;
    fecha_nacimiento:Date;
    acerca_de:string;
    puesto:string;
   

 constructor(id:number,nombre:string,apellido:string,urlfoto:string,fecha_nacimiento:Date,acerca_de:string,puesto:string)
    {
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.urlfoto=urlfoto;
        this.fecha_nacimiento=fecha_nacimiento;
        this.acerca_de=acerca_de;
        this.puesto=puesto;
        
        
    }

}