export class Idioma{
    id?:number;
    lenguaje:string;
    nivel:string;

    constructor(lenguaje:string,nivel:string){
        
        this.lenguaje=lenguaje;
        this.nivel=nivel;
    }

}
