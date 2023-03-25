export class Contacto {

    id?:number
    discord:string
    github:string
    telegram:string

    constructor(discord:string, github:string,telegram:string){
        this.discord=discord
        this.github=github
        this.telegram=telegram
    }


}