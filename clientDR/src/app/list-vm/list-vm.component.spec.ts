import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListVmComponent } from './list-vm.component';

describe('ListVmComponent', () => {
  let component: ListVmComponent;
  let fixture: ComponentFixture<ListVmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListVmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListVmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
