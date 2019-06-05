/**********************************************************************************************
Code generated with MKL Plug-in version: 3.6.2
Code generated at time stamp: 2019-06-05T06:39:17.496
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-kerubin-menu',
  templateUrl: './kerubin-menu.component.html',
  styleUrls: ['./kerubin-menu.component.css']
})
export class KerubinMenuComponent implements OnInit {

  items: MenuItem[];


  constructor() { }

  ngOnInit() {
    this.loadMenu();
  }

  loadMenu() {
    this.items = [

      {
      	label: 'Cadastros',
      	icon: 'pi pi-pw',
      	items: [
      		
      		{
      			label: 'Fornecedor',
      			icon: 'pi pi-fw ',
      			items: [
      				{ label: 'Fornecedor', icon: 'pi pi-fw', routerLink: '/fornecedor' }
      			]
      		}
      		
      	]
      }


    ];
  }

}
