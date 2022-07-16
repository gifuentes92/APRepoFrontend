import * as internal from "stream";

export class educacion{
    id:number;
    school:string;
    title:string;
    carrer:string;
    score:string;
    start:string;
    end:string;


constructor(id:number,school:string, title:string, carrer:string, score:string, start:string, end:string)
{
    this.id=id;
    this.school=school;
    this.title=title;
    this.carrer=carrer;
    this.score=score;
    this.start=start;
    this.end=end;
}
}