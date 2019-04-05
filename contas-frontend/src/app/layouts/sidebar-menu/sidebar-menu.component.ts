import { Component, OnInit } from '@angular/core';
import { LayoutScriptsService } from '../../front/services/layout-scripts.service';

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrls: ['./sidebar-menu.component.css']
})
export class SidebarMenuComponent implements OnInit {

  constructor(private layoutScripts: LayoutScriptsService) { }

  ngOnInit() {
    this.layoutScripts.initSidebar();
  }

  slideOutIn($event): void {

    const $SIDEBAR_MENU = $('#sidebar-menu'),
    $BODY = $('body');
    const _this = this;
    const $li = $($event.target).parent();

        if ($li.is('.active')) {
            $li.removeClass('active active-sm');
            $('ul:first', $li).slideUp(function() {
              _this.layoutScripts.setHeight();
            });
        } else {
            // prevent closing menu if we are on child menu
            if (!$li.parent().is('.child_menu')) {
                $SIDEBAR_MENU.find('li').removeClass('active active-sm');
                $SIDEBAR_MENU.find('li ul').slideUp();
            } else {
                if ( $BODY.is( '.nav-sm' ) ) {
                  $SIDEBAR_MENU.find( 'li' ).removeClass( 'active active-sm' );
                  $SIDEBAR_MENU.find( 'li ul' ).slideUp();
                }
            }
            $li.addClass('active');

            $('ul:first', $li).slideDown(function() {
                _this.layoutScripts.setHeight();
            });
        }
  }
}
