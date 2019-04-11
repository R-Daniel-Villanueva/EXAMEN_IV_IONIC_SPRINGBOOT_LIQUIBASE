import { Pipe, PipeTransform } from '@angular/core';

/**
 * Generated class for the MypipePipe pipe.
 *
 * See https://angular.io/api/core/Pipe for more info on Angular Pipes.
 */
@Pipe({
  name: 'mypipe',/*aqui se puede cambiar el nombre*/ 
})
export class MypipePipe implements PipeTransform {
  /**
   * Takes a value and makes it lowercase.
   */
  transform(value: string, defaultText='Sin texto') {
    return (value)? value: defaultText;
  }
}
