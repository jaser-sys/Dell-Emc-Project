import { filterBy } from './filter-by';

export class Filters {


    radioVal: string;

    static values: filterBy[] = [

        {
            name: 'name',
            viewValue: 'Name'
        },
        {
            name: 'size',
            viewValue: 'Size'
        },
        {
            name: 'date',
            viewValue: 'Creation Date'
        }

    ];
}
