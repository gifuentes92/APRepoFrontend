

export class Educacion{
    id?:number;
    institucion:string;
    titulo:string;
    curso:string;
    inicio:any;
    fin:any;


constructor(institucion:string,titulo:string,curso:string,inicio:any,fin:any)
{
    
    this.institucion=institucion;
    this.titulo=titulo;
    this.curso=curso;
    this.inicio=inicio;
    this.fin=fin;
}
}