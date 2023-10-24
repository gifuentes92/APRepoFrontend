
export class Persona{
    id?:number;
    nombre:string;
    urlfoto:string;
    puesto:string;
    acercade:string;
   

 constructor(nombre:string,urlfoto:string,acercade:string,puesto:string)
    {
    
        this.nombre=nombre;
        this.urlfoto=urlfoto;
        this.acercade=acercade;
        this.puesto=puesto;
        
        
    }

}