import { Component, OnInit } from '@angular/core';
import { LayoutScriptsService } from 'src/app/front/services/layout-scripts.service';

declare function dataTable(element: any): any;

@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.css']
})
export class TopNavComponent implements OnInit {

  constructor(private layoutScripts: LayoutScriptsService) { }

  ngOnInit() {
  }

  resizeMenu(): void {

    const $SIDEBAR_MENU = $('#sidebar-menu'),
    $BODY = $('body');
    const _this = this;

      if ($BODY.hasClass('nav-md')) {
        $SIDEBAR_MENU.find('li.active ul').hide();
        $SIDEBAR_MENU.find('li.active').addClass('active-sm').removeClass('active');
      } else {
        $SIDEBAR_MENU.find('li.active-sm ul').show();
        $SIDEBAR_MENU.find('li.active-sm').addClass('active').removeClass('active-sm');
      }

    $BODY.toggleClass('nav-md nav-sm');

    _this.layoutScripts.setHeight();

    $('.dataTable').each ( function () { dataTable(this); } );
  }

}
