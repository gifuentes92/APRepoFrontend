

export class educacion{
    idEducacion:number;
    institucion:string;
    titulo:string;
    carrera:string;
    nota_promedio:number;
    inicio:any;
    fin:any;


constructor(idEducacion:number,institucion:string, titulo:string, carrera:string, nota_promedio:number, inicio:any, fin:any)
{
    this.idEducacion=idEducacion;
    this.institucion=institucion;
    this.titulo=titulo;
    this.carrera=carrera;
    this.nota_promedio=nota_promedio;
    this.inicio=inicio;
    this.fin=fin;
}
}