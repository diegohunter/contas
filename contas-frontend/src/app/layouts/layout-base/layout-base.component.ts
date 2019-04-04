import { Component, OnInit } from '@angular/core';
import { LayoutScriptsService } from 'src/app/front/front/services/layout-scripts.service';

@Component({
  selector: 'app-layout-base',
  templateUrl: './layout-base.component.html',
  styleUrls: ['./layout-base.component.css']
})
export class LayoutBaseComponent implements OnInit {

  constructor(private layoutScripts: LayoutScriptsService) { }

  ngOnInit() {

    this.layoutScripts.initSidebar();
  }
}
