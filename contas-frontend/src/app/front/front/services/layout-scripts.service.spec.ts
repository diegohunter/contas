import { TestBed } from '@angular/core/testing';

import { LayoutScriptsService } from './layout-scripts.service';

describe('LayoutScriptsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LayoutScriptsService = TestBed.get(LayoutScriptsService);
    expect(service).toBeTruthy();
  });
});
