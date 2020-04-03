import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListFileMultiComponent } from './list-file-multi.component';

describe('ListFileMultiComponent', () => {
  let component: ListFileMultiComponent;
  let fixture: ComponentFixture<ListFileMultiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListFileMultiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListFileMultiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
