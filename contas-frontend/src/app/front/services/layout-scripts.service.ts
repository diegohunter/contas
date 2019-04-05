import { Injectable } from '@angular/core';

declare function init_sidebar(): any;
declare function setContentHeight(): any;

@Injectable({
  providedIn: 'root'
})
export class LayoutScriptsService {


  constructor() { }

  initSidebar(): void {
    init_sidebar();
  }

  setHeight() {
    setContentHeight();
  }
}
