/**********************************************************************************************
Code generated with MKL Plug-in version: 3.6.2
Code generated at time stamp: 2019-06-05T06:39:17.496
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

import { Injectable } from '@angular/core';
import * as localTranslations from 'src/app/modules/cadastros/fornecedor/i18n/pt-br.json';

@Injectable()
export class CadastrosFornecedorTranslationService {

  constructor() { }

  public getTranslation(key: string): string {
      if (localTranslations) {
        const translation = (<any>localTranslations).default[key];
        if (translation !== null) {
          return translation;
        }
      }
      return key;
  }

}